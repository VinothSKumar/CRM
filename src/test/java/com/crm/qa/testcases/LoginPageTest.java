package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	public LoginPageTest() {
		super();
	}
	
	@BeforeClass
	public void setUp() {
		initilization();
		loginpage =new LoginPage();
	}
	
	@Test
	public void loginPageTitleTest() {
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO  - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test
	public void crmLogoImageTest() {
		boolean flag = loginpage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void loginTest() {
		homepage=loginpage.login("username", "password");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
}
