package com.nopcommerce.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	
	public ReadConfig()
	{
		File src=new File("./Configration/config.properties"); // After identifying config properties file will store it in src 
		
		try {
			FileInputStream fis=new FileInputStream(src); // This will call our saved file src
			pro=new Properties();
			pro.load(fis);  // it will load config properties file in class
		}
		catch(Exception e){
			
			System.out.println("Exception is "+ e.getMessage());

			
		}
		
		
	}
	
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	public String getUseremail()
	{
	String username=pro.getProperty("username");
	return username;
	}
	
	public String getPassword()
	{
	String password=pro.getProperty("password");
	return password;
	}



}
