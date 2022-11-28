package com.buffaloCartCRM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffaloCartCRM.utils.PageUtility;
import com.buffaloCartCRM.utils.WaitUtility;

public class LogInPage {
	
	WebDriver driver;
	
	public LogInPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
		this.driver=driver;
		
	}
	
	@FindBy(id = "email")
	WebElement logInEmailField;
	@FindBy(id = "password")
	WebElement logInPasswordField;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement logInSubmitButton;
	@FindBy(xpath = "//h4[text()='Dashboard']")
	public WebElement dashboardTitle;
	
	public void logIn(String email, String password) {

		PageUtility.enterText(logInEmailField, email);
		PageUtility.enterText(logInPasswordField, password);
		PageUtility.clickButton(driver, logInSubmitButton);
		
		WaitUtility.waitExplicitToBevisibilityOfAllElements(dashboardTitle);

		dashboardTitle.isDisplayed(); 

	}

}
