package com.banking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomer {
	WebDriver Idriver;
	
	public AddCustomer(WebDriver rdriver) {
		// TODO Auto-generated constructor stub
		Idriver = rdriver;
		PageFactory.initElements(Idriver, this);
	}
	
	@FindBy(how = How.XPATH , using = "//a[contains(text(),'New Customer')]")
	@CacheLookup
	WebElement AddNewCustomer;
	
	
	@FindBy(how = How.NAME , using = "name")
	@CacheLookup
	WebElement custName;
	
	@FindBy(how = How.NAME , using = "rad1")
	@CacheLookup
	WebElement custGender;
	
	@FindBy(how = How.ID_OR_NAME , using = "dob")
	@CacheLookup
	WebElement custDOB;
	
	@FindBy(how = How.NAME , using = "addr")
	@CacheLookup
	WebElement custAddress;
	
	@FindBy(how = How.NAME , using = "city")
	@CacheLookup
	WebElement custCity;
	
	@FindBy(how = How.NAME , using = "state")
	@CacheLookup
	WebElement custState;
	
	@FindBy(how = How.NAME , using = "pinno")
	@CacheLookup
	WebElement custPinno; 
	
	@FindBy(how = How.NAME , using = "telephoneno")
	@CacheLookup
	WebElement custMobNo;
	
	@FindBy(how = How.NAME , using = "emailid")
	@CacheLookup
	WebElement custEmailId;
	
	@FindBy(how = How.NAME , using = "password")
	@CacheLookup
	WebElement custPwd;
	
	@FindBy(how = How.NAME , using = "sub")
	@CacheLookup
	WebElement Submit;
	
	public void AddNewCustomer(){
		AddNewCustomer.click();
		
	}
	
	public void custName(String cname){
		custName.sendKeys(cname);
		
	}
	public void custGender(String cgender){
		custGender.click();
		
	}
	public void custDOB(String mm , String dd , String yy){
		custDOB.sendKeys(mm);
		custDOB.sendKeys(dd);
		custDOB.sendKeys(yy);
		
	}
	public void custAddress(String address){
		custAddress.sendKeys(address);
		
	}
	public void custCity(String city){
		custCity.sendKeys(city);
		
	}
	public void custState(String state){
		custState.sendKeys(state);
		
	}
	
	public void custPin(int Pin){
		custPinno.sendKeys(String.valueOf(Pin));
		
	}
	
	public void custMobNo(String MobNo){
		custMobNo.sendKeys(MobNo);
		
	}
	
	public void custEmailId(String emailid){
		custEmailId.sendKeys(emailid);
		
	}
	public void custPWD(String pwd){
		custPwd.sendKeys(pwd);
		
	}
	public void submit(){
		
		Submit.click();
	}

	
}
