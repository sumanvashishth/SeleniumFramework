package com.banking.testcase;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.banking.pageobjects.AddCustomer;
import com.banking.pageobjects.LoginPage;

import junit.framework.Assert;

public class TC_AddCustomerTest_003 extends BaseClass {
	@Test
	public void addnewcustomer() throws InterruptedException{
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Username entered");
		lp.setPassword(password);
		logger.info("Password entered");
		lp.clickSubmit();
		logger.info("Login");
		Thread.sleep(3000);
		
		AddCustomer addcstmr = new AddCustomer(driver);
		
		addcstmr.AddNewCustomer();
		logger.info("Providing customer details");
		Thread.sleep(2000);
		addcstmr.custName("Hope");
		Thread.sleep(1000);
		addcstmr.custGender("female");
		Thread.sleep(1000);
		addcstmr.custDOB("30", "07", "1990");
		Thread.sleep(1000);
		addcstmr.custAddress("B 467 Sec19 Noida");
		Thread.sleep(1000);
		addcstmr.custCity("Noida");
		Thread.sleep(1000);
		addcstmr.custState("UP");
		Thread.sleep(1000);
		addcstmr.custPin(123321);
		Thread.sleep(1000);
		addcstmr.custMobNo("980324562");
		Thread.sleep(1000);
		String emailid = randomstring()+"@gmail.com";
		addcstmr.custEmailId(emailid);
		addcstmr.custPWD("abc@123");
		Thread.sleep(3000);
		addcstmr.submit();
		Thread.sleep(1500);
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true){
			logger.info("test case passed");
			Assert.assertTrue(true);
		}
		else{
			logger.info("test case failed");
			Assert.assertTrue(false);
		}
		
	}
	

	
}
