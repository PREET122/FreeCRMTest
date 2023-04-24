package com.crm.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	//Page factory - object repository(OR):
	
	@FindBy(xpath = "/html/body/div/header/div/nav/div[2]/div/div[2]/ul/a")
	WebElement login1;
	
	@FindBy(xpath = "/html/body/div/main/section[1]/a")
	WebElement signUp;
	
	@FindBy(xpath = "/html/body/div/header/div/nav/div[2]/div/div[1]/div/a")
	WebElement logo;
	
	@FindBy(name = "email")
	WebElement email;
	
	@FindBy(name = "password")
	WebElement pass;
	
	@FindBy(xpath = "//*[@id=\"ui\"]/div/div/form/div/div[3]")
	WebElement loginbtn;
	
	//Initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions :
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		return logo.isDisplayed();
	}
	
	public void log1(){
		login1.click();
	}
	public HomePage login(String un, String pwd) {
		email.sendKeys(un);
		pass.sendKeys(pwd);
		loginbtn.click();
		
		return new HomePage();
	}

}

