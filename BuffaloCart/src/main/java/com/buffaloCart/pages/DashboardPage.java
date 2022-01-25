package com.buffaloCart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.buffaloCart.utils.PageUtility;
import com.buffaloCart.utils.WaitUtility;

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
	@FindBy(xpath = "//*[contains(text(), 'Clock Out')]")
	WebElement clockedIn;
	@FindBy(xpath = "//*[contains (text(),'Clock started at')]")
	WebElement getInTime;

	@FindBy(xpath = "//span[text()='My open tasks']//parent::div")
	WebElement myOpenTasks;
	@FindBy(xpath = "//h4[text()='Tasks']")
	WebElement tasksPageLoad;
	
	@FindBy(xpath = "//span[text()='Events today']//parent::div")
	WebElement eventsToday;
	@FindBy(xpath = "//h1[text()='Event calendar']")
	WebElement eventsPageLoad;
	
	@FindBy(xpath = "//span[text()='New posts']//parent::div")
	WebElement newPosts;
	@FindBy(id = "timeline")
	WebElement timelinePageLoad;
	
	@FindBy(xpath = "//span[text()='Dashboard']//parent::a")
	WebElement dashboard;
	
	boolean display;
	
	public void homeDashBoard() {
		PageUtility.clickButton(driver, dashboard);
	}

	public void clockIN() {
		SoftAssert softAssert = new SoftAssert();
		display = PageUtility.displayed(clockedOut);
		softAssert.assertTrue(display,"Already Clocked Out");
		PageUtility.clickButton(driver, clockIn);
		
		WaitUtility.waitImplicit(4);
		WaitUtility.waitExplicitToBevisibilityOfAllElements(clockedIn);
		
		driver.navigate().refresh();
		
		softAssert.assertAll();
		String time = PageUtility.getText(getInTime);
		System.out.println("Check In time "+time);
	}
	
	public void openTasks() {
		PageUtility.clickButton(driver, myOpenTasks);
		WaitUtility.waitExplicitToBevisibilityOfAllElements(tasksPageLoad);
	}
	
	public void openEvent() {
		PageUtility.clickButton(driver, eventsToday);
		WaitUtility.waitExplicitToBevisibilityOfAllElements(eventsPageLoad);
	}
	
	public void openTeamsTimeline() {
		PageUtility.clickButton(driver, newPosts);
		WaitUtility.waitExplicitToBevisibilityOfAllElements(timelinePageLoad);
	}
	
	public void returnHome() {
		PageUtility.clickButton(driver, dashboard);
	}


}
