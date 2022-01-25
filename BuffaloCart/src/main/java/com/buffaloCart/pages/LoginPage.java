package com.buffaloCart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffaloCart.utils.PageUtility;
import com.buffaloCart.utils.WaitUtility;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;

	}

	@FindBy(id = "email")
	WebElement emailField;
	@FindBy(id = "password")
	WebElement passwordField;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitButton;
	@FindBy(xpath = "//div[@role='alert']")
	public WebElement authFailed;
	
	public boolean logIn(String email, String password) {

		PageUtility.enterText(emailField, email);
		PageUtility.enterText(passwordField, password);
		PageUtility.clickButton(driver, submitButton);
		WaitUtility.waitImplicit(4);

		boolean auth =authFailed.isDisplayed(); 
		return auth;

	}

}
