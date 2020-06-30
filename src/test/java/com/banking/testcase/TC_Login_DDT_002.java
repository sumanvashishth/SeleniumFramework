package com.banking.testcase;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.banking.pageobjects.LoginPage;
import com.banking.utilities.XLUtils;

import junit.framework.Assert;

public class TC_Login_DDT_002 extends BaseClass{

	@Test (dataProvider = "logindata")
	public void loginDDT(String uname , String pwd) throws InterruptedException{
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(uname);
		logger.info("Usrname entered");
		lp.setPassword(pwd);
		logger.info("Password entered");
		lp.clickSubmit();
		Thread.sleep(2000);
		if(isAlertPresent()==true){
			logger.info("Login Failed");
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Thread.sleep(1000);
			Assert.assertTrue(false);
		}
		else{
			logger.info("Login Passed");
			Thread.sleep(2000);
			Assert.assertTrue(true);
			lp.clicklogout();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	
	public boolean isAlertPresent() throws InterruptedException{
		try{
		driver.switchTo().alert();
		Thread.sleep(2000);
		return true;
		}
		catch(NoAlertPresentException e){
			return false;
		}
		
	}

	@DataProvider(name = "logindata")
	String [][] getdata() throws IOException{
		
		String file = System.getProperty("user.dir")+"/src/test/java/com/banking/testdata/data.xlsx";
		int rowcount = XLUtils.getrowcount(file, "sample") ;
		int colcount = XLUtils.getcelllcount(file, "sample", 1);
		String logindata[][] = new String [rowcount][colcount];		
		for(int i = 1 ; i<=rowcount ; i++){
			for( int j = 0 ; j<colcount ; j++){
				logindata[i-1][j]=XLUtils.getCellData(file, "sample", i, j);
			}
		}
		return logindata;
		
	}
	
}

