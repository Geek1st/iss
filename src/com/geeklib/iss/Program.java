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
		
		String tagPath = FileSystemView.getFileSystemView().getHomeDirectory() + "\\shadowsocks.txt";
		
		String line = new String();
		FileWriter fileWriter = new FileWriter(tagPath);
		
		while ((line = reader.readLine()) != null)
		{
			if (0 < line.indexOf("服务器地址:"))
			{
				fileWriter.append(line.substring(line.indexOf("<h4>") + 4, line.indexOf("</h4>")));
				fileWriter.append(System.getProperty("line.separator"));
			}
			else if(0 < line.indexOf("端口:"))
			{
				fileWriter.append(line.substring(line.indexOf("<h4>") + 4, line.indexOf("</h4>")));
				fileWriter.append(System.getProperty("line.separator"));
			}
			else if(0 < line.indexOf("密码:"))
			{
				fileWriter.append(line.substring(line.indexOf("<h4>") + 4, line.indexOf("</h4>")));
				fileWriter.append(System.getProperty("line.separator") + System.getProperty("line.separator"));
			}
		}
		
		fileWriter.close();
		reader.close();
		
		Runtime.getRuntime().exec("notepad " + tagPath);
	}
}