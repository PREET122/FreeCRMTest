package com.crm.qa.testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	TestUtil testutil;
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp()  {
		Intialization();
		WebElement login1 = driver.findElement(By.xpath("/html/body/div/header/div/nav/div[2]/div/div[2]/ul/a"));
		login1.click();
		contactspage = new ContactsPage();
		testutil = new TestUtil();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactspage = homepage.clickOnContacts();
	}
	
	
	@Test(priority = 1)
	public void verifyContactsPageLabel() {
		Assert.assertTrue(contactspage.verifyContactslabel());
	}
	
	@Test(priority = 2)
	public void selectContactsTest() throws InterruptedException {
		Thread.sleep(1000);
		contactspage.selectContactsByName("yash goswami");
	}
	
	@Test(priority = 3)
	public void verifyNewContactCreated() throws InterruptedException {
		homepage.clickOnNewContactLink();
		Thread.sleep(1000);
		contactspage.clickOnCancel();
		Thread.sleep(1000);
		homepage.clickOnNewContactLink();
		
		contactspage.createNewContact("bhavesh", "joshi", "sada@gmail.com");
		
	}
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
