package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	@FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[1]/span")
	WebElement contactLabel;
	
	@FindBy(xpath = ("//input[@name=\"first_name\"]"))
	WebElement fname;
	
	@FindBy(xpath = ("//input[@name=\"last_name\"]"))
	WebElement lname;
	
	@FindBy(xpath = ("//input[@name=\"value\"]"))
	WebElement email;
	
	@FindBy(xpath = ("//button[contains(text(), \"Save\")]"))
	WebElement savebtn;
	
	@FindBy(xpath = ("//button[contains(text(), \"Cancel\")]"))
	WebElement cancelbtn;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactslabel() {
		return contactLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name) {
		driver.navigate().refresh();
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]"));
		
	}
	
	public void createNewContact(String ftname, String ltname, String Email) {
		
		fname.sendKeys(ftname);
		lname.sendKeys(ltname);
		email.sendKeys(Email);
		savebtn.click();
	}
	
	public void clickOnCancel() {
		cancelbtn.click();
	}
	
}

