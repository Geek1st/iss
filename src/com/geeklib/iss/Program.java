package com.geeklib.iss;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.swing.filechooser.FileSystemView;

public class Program
{
	public static void main(String[] args) throws IOException
	{
		URL iss = new URL("http://www.ishadowsocks.org/");

		BufferedReader reader = new BufferedReader(new InputStreamReader(iss.openStream(), StandardCharsets.UTF_8));
		
		String line = new String();
		FileWriter fileWriter = new FileWriter(FileSystemView.getFileSystemView().getHomeDirectory() + "\\shadowsocks.txt");
		while ((line = reader.readLine()) != null)
		{
			System.out.println(line);
			if (line.indexOf("服务器地址:") > 0)
			{
				fileWriter.append(line.substring(line.indexOf("<h4>") + 4, line.indexOf("</h4>")));
				fileWriter.append("\n");
				System.out.println(line.substring(line.indexOf("<h4>") + 4, line.indexOf("</h4>")));
			}
			else if(line.indexOf("端口:") > 0)
			{
				fileWriter.append(line.substring(line.indexOf("<h4>") + 4, line.indexOf("</h4>")));
				fileWriter.append("\n");
			}
			else if(line.indexOf("密码:") > 0)
			{
				fileWriter.append(line.substring(line.indexOf("<h4>") + 4, line.indexOf("</h4>")));
				fileWriter.append("\n\n");
			}
		}
		fileWriter.close();
		reader.close();
	}
}
