package com.banking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig(){
		File src = new File("./Configurations/config.properties");
		try{
		FileInputStream fis = new FileInputStream(src);
		pro = new Properties();
		pro.load(fis);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("exception is "+e.getMessage());
		}
		
	}
	public String getURL(){
		String URL = pro.getProperty("baseURL");
		return URL;
		
	}
	public String getusername(){
		String uname = pro.getProperty("username");
		return uname;
		
	}
	public String getpassword(){
		String pwd = pro.getProperty("password");
		return pwd;
		
	}
	public String getchromepath(){
		String chrome = pro.getProperty("chromepath");
		return chrome;
		
	}
	public String getfirefoxpath(){
		String firefox = pro.getProperty("firefoxpath");
		return firefox;
		
	}
	public String getIEpath(){
		String IE = pro.getProperty("IE");
		return IE;
		
	}
	
	
}
