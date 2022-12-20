package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	TasksPage taskspage;
	ContactsPage contactspage;
	DealsPage dealspage;
	TestUtil testutil;
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initilization();
		loginpage=new LoginPage();
		homepage=new HomePage();
		contactspage =new ContactsPage();
		taskspage=new TasksPage();
		testutil =new TestUtil();
		homepage=loginpage.login("username", "password");
		//testutil.switchToFrame();
		contactspage=homepage.validateContactsLink();
	}
	
	@Test
	public void validateContactsLabelTest() {
		Assert.assertTrue(contactspage.validateContactsLabel(), "Contacts is not visible");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
