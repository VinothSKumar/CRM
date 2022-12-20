package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//td[contains(text(),'User: Aravindhaan Kumar')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement btnContacts;
	
	@FindBy(xpath="//a[text()='Deals']")
	WebElement btnDeals;
	
	@FindBy(xpath="//a[text()='Tasks']")
	WebElement btnTasks;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle(); 
	}
	
	public boolean validateuserNameLabel() {
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage validateContactsLink() {
		btnContacts.click();
		return new ContactsPage();
	}
	
	public DealsPage validateDealsLink() {
		btnDeals.click();
		return new DealsPage();
	}
	
	public TasksPage validateTasksLink() {
		btnTasks.click();
		return new TasksPage();
	}
	
	
	
	
	
	
	
	
	
	
	
}
