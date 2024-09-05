package com.page.object;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends BaseClass {
	ScreenshotCode ss;

	@FindBy(xpath = "//*[@id=\"username\"]")
	private WebElement usernameTextbox;

	@FindBy(xpath = "//*[@id=\"password\"]")
	private WebElement passwordTextbox;

	@FindBy(xpath = "//*[@id=\"login_form\"]/table/tbody/tr[1]/td")
	private WebElement TextLoginPage;

	@FindBy(xpath = "//*[@id=\"login\"]")
	private WebElement loginButton;

	@FindBy(xpath = "//*[@id=\"username_span\"]")
	private WebElement ValidationErrorMsgUsernameTextboxLoginPage;

	@FindBy(xpath = "//*[@id=\"password_span\"]")
	private WebElement ValidationErrorMsgPasswordTextboxLoginPage;
	
	@FindBy(xpath = "//*[@id=\"login_form\"]/table/tbody/tr[5]/td[2]/div/b")
	private WebElement InvalidUserValidationErrorMsgLoginPage;
	
	public LoginPageObject() {
		// TODO Auto-generated constructor stub

		PageFactory.initElements(driver, this);

	}

	public void inputLoginPage(String US, String PW, String LT) {
		setText(usernameTextbox, US);
		setText(passwordTextbox, PW);
		// selectFromDropDown(logintypeDropdown, LT);
	}

	public boolean LoginPageOpened(String Tc) throws IOException, InterruptedException {
		Thread.sleep(1000);
		ss.passScreenCapture(driver, Tc);
		if (TextLoginPage.isDisplayed()) {
			return true;
		}

		return false;
	}
	public boolean UsernameTextboxDisplayed(String Tc) throws IOException, InterruptedException {
		Thread.sleep(1000);
		ss.passScreenCapture(driver, Tc);
		if (usernameTextbox.isDisplayed()) {
			return true;
		}

		return false;
	}
	
	public boolean PasswordTextboxDisplayed(String Tc) throws IOException, InterruptedException {
		Thread.sleep(1000);
		ss.passScreenCapture(driver, Tc);
		if (passwordTextbox.isDisplayed()) {
			return true;
		}

		return false;
	}

	public boolean LoginButtonIsDisplayed(String Tc) throws IOException, InterruptedException {
		Thread.sleep(1000);
		ss.passScreenCapture(driver, Tc);
		if (loginButton.isDisplayed()) {
			return true;
		}

		return false;
	}
	
	public boolean LoginButtonEnabled(String Tc) throws IOException, InterruptedException {
		Thread.sleep(1000);
		ss.passScreenCapture(driver, Tc);
		if (loginButton.isEnabled()) {
			return true;
		}

		return false;
	}
	
	public boolean UsernameTextboxEmptyDefault(String Tc) throws IOException, InterruptedException {
		Thread.sleep(1000);
		ss.passScreenCapture(driver, Tc);
		if (usernameTextbox.getText().equals("")) {
			return true;
		}

		return false;
	}
	
	public boolean PasswordTextboxEmptyDefault(String Tc) throws IOException, InterruptedException {
		Thread.sleep(1000);
		ss.passScreenCapture(driver, Tc);
		if (passwordTextbox.getText().equals("")) {
			return true;
		}

		return false;
	}
}
