package com.buffaloCart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffaloCart.utils.PageUtility;
import com.buffaloCart.utils.WaitUtility;

public class ForgotPasswordPage {
	
	WebDriver driver;
	
	public ForgotPasswordPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(xpath = "//a[text()='Forgot password?']")
	WebElement forgotPasswordButton;
	@FindBy(xpath = "//a[text()='Sign in']")
	WebElement backToSignInPage;
	
	@FindBy(xpath = "//h2[text()='Forgot password?']")
	WebElement forgotPasswordPage;
	
	public void forgotPassword() {
		PageUtility.clickButton(driver, forgotPasswordButton);
		WaitUtility.waitExplicitToBevisibilityOfAllElements(forgotPasswordPage);
		PageUtility.clickButton(driver, backToSignInPage);
	}

}
