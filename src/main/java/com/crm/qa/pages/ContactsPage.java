package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateContactsLabel() {
		return contactsLabel.isDisplayed(); 
	}
					
}
