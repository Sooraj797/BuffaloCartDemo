package com.buffaloCart.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.buffaloCart.utils.PageUtility;

public class DashboardPage {

	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//a[@title='Clock In']//parent::a")
	WebElement clockIn;
	@FindBy(xpath = "//a[text()=' Clock In']")
	WebElement clockedOut;
	@FindBy(xpath = "//*[contains (text(),'Clock started at')]")
	WebElement getInTime;

	@FindBy(xpath = "//span[text()='My open tasks']//parent::div")
	WebElement myOpenTasks;
	
	@FindBy(xpath = "//span[text()='Events today']//parent::div")
	WebElement eventsToday;
	
	@FindBy(xpath = "//span[text()='New posts']//parent::div")
	WebElement newPosts;
	
	@FindBy(xpath = "//span[text()='Dashboard']//parent::a")
	WebElement dashboard;
	
	boolean display;

	public void clockIN() {
		SoftAssert softAssert = new SoftAssert();
		display = PageUtility.displayed(clockedOut);
		softAssert.assertTrue(display,"Already Clocked Out");
		PageUtility.clickButton(driver, clockIn);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.navigate().refresh();
		softAssert.assertAll();
		String time = PageUtility.getText(getInTime);
		System.out.println("Check In time "+time);
	}
	
	public void openTasks() {
		PageUtility.clickButton(driver, myOpenTasks);
	}
	
	public void openEvent() {
		PageUtility.clickButton(driver, eventsToday);
	}
	
	public void openTeamsTimeline() {
		PageUtility.clickButton(driver, newPosts);
	}
	
	public void returnHome() {
		PageUtility.clickButton(driver, dashboard);
	}


}
