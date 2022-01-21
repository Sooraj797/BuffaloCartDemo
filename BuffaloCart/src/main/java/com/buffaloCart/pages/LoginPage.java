package com.buffaloCart.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.buffaloCart.utils.PageUtility;

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
	WebElement authFailed;
	
	public void logIn(String email, String password) {

		PageUtility.enterText(emailField, email);
		PageUtility.enterText(passwordField, password);
		PageUtility.clickButton(driver, submitButton);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		/*
		 * SoftAssert softAssert = new SoftAssert(); boolean auth =
		 * authFailed.isDisplayed(); softAssert.assertTrue(auth,
		 * "Credentials is Wrong"); softAssert.assertAll();
		 */

	}

}
