package com.buffaloCart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.buffaloCart.utils.PageUtility;
import com.buffaloCart.utils.WaitUtility;

public class LogOutPage {
	
	WebDriver driver;
	
	public LogOutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	boolean display;
	
	@FindBy(xpath = "(//a[text()=' Clock Out'])")
	WebElement clockOutButton;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement clockOutSaveButton;
	@FindBy(xpath = "//a[text()=' Clock In']")
	WebElement clockedOut;
	
	@FindBy(xpath = "(//a[@id='user-dropdown']//parent::a//child::span)[1]")
	WebElement signOutDropdown;
	@FindBy(xpath = "(//a[text()=' Sign Out'])")
	WebElement signOutButton;
	
	public void clockOut() {
		SoftAssert softAssert = new SoftAssert();
		display = PageUtility.displayed(clockOutButton);
		softAssert.assertTrue(display,"Already Clocked In");
		PageUtility.clickButton(driver, clockOutButton);
		PageUtility.clickButton(driver, clockOutSaveButton);
		
		WaitUtility.waitImplicit(4);
		WaitUtility.waitExplicitToBevisibilityOfAllElements(clockedOut);
		
		softAssert.assertAll();
	}
	
	public void logOut() {
		PageUtility.clickButton(driver, signOutDropdown);
		PageUtility.clickButton(driver, signOutButton);
	}

}
