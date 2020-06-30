package com.banking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver Idriver;
	
	public LoginPage(WebDriver rdriver) {
		Idriver = rdriver;
		PageFactory.initElements(Idriver, this);
	}
	
	 @FindBy(name ="uid")
	 @CacheLookup
	 WebElement txtUsername;
	 
	 @FindBy(name ="password")
	 @CacheLookup
	 WebElement txtPassword;
	 
	 @FindBy(name ="btnLogin")
	 @CacheLookup
	 WebElement btnLogin;
	 
	 @FindBy(xpath = "//a[contains(text(),'Log out')]")
	 @CacheLookup
	 WebElement logout;
	 
	 public void setUsername(String uname){
		 txtUsername.sendKeys(uname);
		 
	 }
	 public void setPassword(String pwd){
		 txtPassword.sendKeys(pwd);
		 
	 }
	 public void clickSubmit(){
		 btnLogin.click();
		 
	 }
	 public void clicklogout(){
		 logout.click();
	 }
	 
}
