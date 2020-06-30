package com.banking.testcase;


import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.banking.pageobjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{

	@Test
	public void logintest() throws InterruptedException{
		logger.info("URL is opened");
		LoginPage lp= new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Username entered");
		lp.setPassword(password);
		logger.info("Password entered");
		lp.clickSubmit();
		
	}
	@Test
	public void verify() throws InterruptedException{
		String title = driver.getTitle();
		if(title.equals("Guru99 Bank Manager HomePage")){
			
			AssertJUnit.assertTrue(true);
			logger.info("TC Passed");
		}
		else{
			System.out.println("Title is "+title);
			AssertJUnit.assertTrue(false);
			logger.info("TC Failed");
		}
		Thread.sleep(3000);
	}
	
}
	

