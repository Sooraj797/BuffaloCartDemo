package com.buffaloCart.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.buffaloCart.utils.PageUtility;

public class CreateAccountPage {
	
	WebDriver driver;
	
	public CreateAccountPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver=driver;
		
	}
	
	@FindBy(xpath="//a[text()='Sign up']")
	WebElement signUp;
	@FindBy(name="first_name")
	WebElement firstName;
	@FindBy(name="last_name")
	WebElement lastName;
	@FindBy(name= "company_name")
	WebElement companyName;
	@FindBy(name= "email")
	WebElement emailId;
	@FindBy(name="password")
	WebElement password;
	@FindBy(name="retype_password")
	WebElement retypePassword;
	@FindBy(id="retype_password_error")
	WebElement retypePasswordError;
	@FindBy(xpath= "//button[@type='submit']")
	WebElement submitButton;
	@FindBy(xpath="//div[text()='Account already exists for your email address. ']")
	WebElement enterEmail;
	@FindBy(xpath="//div[text()='Your account has been created successfully! ']")
	WebElement account;
	@FindBy(xpath="//a[text()='Sign in']")
	WebElement signIn;
	
	public void createAccount(ArrayList<String> list) {
		
		PageUtility.clickButton(driver, signUp);
		PageUtility.enterText(firstName, list.get(0));
		PageUtility.enterText(lastName, list.get(1));
		PageUtility.enterText(companyName, list.get(2));
		PageUtility.enterText(emailId, list.get(3));
		PageUtility.enterText(password, list.get(4));
		PageUtility.enterText(retypePassword, list.get(5)); 
		/*
		 * if(!password.equals(retypePassword)) {
		 * PageUtility.getText(retypePasswordError); retypePasswordError.clear();
		 * PageUtility.enterText(retypePassword, null); }
		 */
		/*
		 * PageUtility.clickButton(driver, submitButton); SoftAssert softAssert = new
		 * SoftAssert(); boolean mail = enterEmail.isDisplayed();
		 * softAssert.assertTrue(mail, "Enter the email again"); softAssert.assertAll();
		 * PageUtility.enterText(emailId, null);
		 */
		PageUtility.clickButton(driver, submitButton);
		SoftAssert softAssert = new SoftAssert();
		boolean acnt = account.isDisplayed();
		softAssert.assertTrue(acnt, "Account is created Sucessfully");
		PageUtility.clickButton(driver, signIn);
	
	}

}
