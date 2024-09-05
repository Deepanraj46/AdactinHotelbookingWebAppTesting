package com.page.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.page.object.LoginPageObject;


public class LoginPageTest extends ExtentReportBaseCode{
	LoginPageObject Lp;

	public LoginPageTest() {

		Lp = new LoginPageObject();
	}

	// Verify the Login page should display.

	@BeforeClass
	public void createTestExtentReport() {
		suiteTest = extent.createTest("Login Page", "Funtionality test");
	}

	public void LogReport(String ClassName) {
			logger = suiteTest.createNode(ClassName, "test the login funtion");

	}

	@Test(enabled = true, priority = 1)
	public void verifyLoginPageOpened() throws Exception {
		LogReport("To verify Loge Page Header");		
		Assert.assertTrue(Lp.LoginPageOpened("LP001"), "Login page is opened");
	
	}
	
	@Test(enabled = true, priority = 2)
	public void verifyUsernameTextboxDisplayed() throws Exception {
		LogReport("To verify Loge Page Header");		
		Assert.assertTrue(Lp.UsernameTextboxDisplayed("LP001"), "Login page is opened");
	
	}
	
	@Test(enabled = true, priority = 3)
	public void verifyPasswordTextboxDisplayed() throws Exception {
		LogReport("To verify Loge Page Header");		
		Assert.assertTrue(Lp.PasswordTextboxDisplayed("LP001"), "Login page is opened");
	
	}
	
	@Test(enabled = true, priority = 4)
	public void verifyLoginButtonIsDisplayed() throws Exception {
		LogReport("To verify Loge Page Header");		
		Assert.assertTrue(Lp.LoginButtonIsDisplayed("LP001"), "Login page is opened");
	
	}
	
	@Test(enabled = true, priority = 5)
	public void verifyLoginButtonEnabled() throws Exception {
		LogReport("To verify Loge Page Header");		
		Assert.assertTrue(Lp.LoginButtonEnabled("LP001"), "Login page is opened");
	
	}
	
	@Test(enabled = true, priority = 6)
	public void verifyUsernameTextboxEmptyDefault() throws Exception {
		LogReport("To verify Loge Page Header");		
		Assert.assertTrue(Lp.UsernameTextboxEmptyDefault("LP001"), "Login page is opened");
	
	}
	
	@Test(enabled = true, priority = 7)
	public void verifyPasswordTextboxEmptyDefault() throws Exception {
		LogReport("To verify Loge Page Header");		
		Assert.assertTrue(Lp.PasswordTextboxEmptyDefault("LP001"), "Login page is opened");
	
	}
	
	@Test(enabled = true, priority = 8)
	public void verifyUsernameTextboxEmptyValidation() throws Exception {
		LogReport("To verify Loge Page Header");		
		Assert.assertTrue(Lp.UsernameTextboxEmptyValidation("LP001"), "Login page is opened");
	
	}
	
	@Test(enabled = true, priority = 9)
	public void verifyPasswordTextboxEmptyValidation() throws Exception {
		LogReport("To verify Loge Page Header");		
		Assert.assertTrue(Lp.PasswordTextboxEmptyValidation("LP001"), "Login page is opened");
	
	}
}
