package com.banking.testcase;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.banking.utilities.ReadConfig;



public class BaseClass {
	ReadConfig readconfig = new ReadConfig();
	
	public String baseURL = readconfig.getURL();
	public String username = readconfig.getusername();
	public String password = readconfig.getpassword();
	public static WebDriver driver;
	Logger logger;
	
	@Parameters ("browser")
	@BeforeClass
	public void setup(String br){
		logger = Logger.getLogger("Banking");
		PropertyConfigurator.configure("Log4j.properties");
		
		 if (br.equals("firefox")) {
			String path = System.setProperty("webdriver.gecko.driver", readconfig.getfirefoxpath());
			driver = new FirefoxDriver();
		}
		
		else if(br.equals("chrome")){
		String path = System.setProperty("webdriver.chrome.driver", readconfig.getchromepath());
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--no-sandbox");
		opt.addArguments("start-maximized");
		opt.addArguments("--headless");
	/*	opt.addArguments("--disable-gpu");
		opt.addArguments("--window-size=1024,768");*/
		opt.addArguments("--remote-debugging-port=9222");
		opt.addArguments("--disable-dev-shm-usage");
		opt.addArguments("--silent");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		}

		else if (br.equals("ie")) {
			String path = System.setProperty("webdriver.ie.driver", readconfig.getIEpath());
			driver = new InternetExplorerDriver();
		}
		 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		
	}

	/// Hey
	public String randomstring(){
		
		String generatedString = RandomStringUtils.randomAlphabetic(8);
		return generatedString ;
	}
	
	public String randomnumber(){
		
		String genratedno = RandomStringUtils.randomNumeric(5);
		return genratedno ;
	}


	@AfterClass
	public void teardown(){
		//driver.quit();
		
	}
	
}
