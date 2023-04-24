package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	Actions action;
	
	@FindBy(xpath = "//*[@id=\"top-header-menu\"]/div[2]/span[1]")
	WebElement usernameLabel;
	
	@FindBy(xpath = "//*[@id=\"main-nav\"]/div[3]/a/i")
	WebElement contacts;
	
	@FindBy(xpath = "//*[@id=\"main-nav\"]/div[5]/a/i")
	WebElement deals;
	
	@FindBy(xpath = "//*[@id=\"main-nav\"]/div[6]/a/i")
	WebElement tasks;
	
	@FindBy(xpath = "//*[@id=\"main-nav\"]/div[3]/button")
	WebElement addContact;
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContacts() {
		contacts.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDeals() {
		deals.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasks() {
		tasks.click();
		return new TasksPage();
	}
	
	public boolean verifyUserName() {
		return usernameLabel.isDisplayed();
	}
	
	public void clickOnNewContactLink() {
		action = new Actions(driver);
		action.moveToElement(contacts);
		
		addContact.click();	
	}
	

	
	
}
