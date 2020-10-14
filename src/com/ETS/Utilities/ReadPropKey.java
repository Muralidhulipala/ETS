package com.ETS.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropKey {

	String config_path="D:\\selenium programs\\ETSProject\\src\\com\\ETSProject\\Properties\\config.properties";
	
	Properties prop=new Properties();
	public String readpropkey(String key) throws IOException
	{
		File file=new File(config_path);
		try {
			FileInputStream fs=new FileInputStream(file);
			prop.load(fs);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}




}
