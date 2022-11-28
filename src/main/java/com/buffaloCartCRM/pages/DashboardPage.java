package com.buffaloCartCRM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffaloCartCRM.utils.PageUtility;
import com.buffaloCartCRM.utils.WaitUtility;

public class DashboardPage {

	WebDriver driver;

	public DashboardPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;

	}

	@FindBy(xpath = "//a[@title='Clock In']//parent::a")
	WebElement dashboardClockIn;
	@FindBy(xpath = "//a[text()=' Clock In']")
	WebElement dashboardClockedOut;
	@FindBy(xpath = "//*[contains(text(), 'Clock Out')]")
	WebElement dashboardClockedIn;
	@FindBy(xpath = "//*[contains (text(),'Clock started at')]")
	WebElement dashboardGetInTime;

	@FindBy(xpath = "//span[text()='My open tasks']//parent::div")
	WebElement dashboardMyOpenTasks;
	@FindBy(xpath = "//h4[text()='Tasks']")
	WebElement dashboardTasksPageLoad;

	@FindBy(xpath = "//span[text()='Events today']//parent::div")
	WebElement dashboardEventsToday;
	@FindBy(xpath = "//h1[text()='Event calendar']")
	WebElement dashboardEventsPageLoad;

	@FindBy(xpath = "//span[text()='New posts']//parent::div")
	WebElement dashboardNewPosts;
	@FindBy(id = "timeline")
	WebElement dashboardNewPostsPageLoad;

	@FindBy(xpath = "//span[text()='Dashboard']//parent::a")
	WebElement returnDashboard;
	@FindBy(xpath = "//h4[text()='Dashboard']")
	public WebElement checkDashboardTitle;

	boolean display;

	public boolean clockIn() {

		PageUtility.clickButton(driver, dashboardClockIn);
		WaitUtility.waitExplicitToBevisibilityOfAllElements(dashboardClockedIn);

		String time = PageUtility.getText(dashboardGetInTime);
		System.out.println("Check In time " + time);

		display = PageUtility.displayed(dashboardClockedIn);
		return display;

	}

	public void openTask() {

		PageUtility.clickButton(driver, dashboardMyOpenTasks);
		WaitUtility.waitExplicitToBevisibilityOfAllElements(dashboardTasksPageLoad);
		
	}

	public void openEvent() {
		
		PageUtility.clickButton(driver, dashboardEventsToday);
		WaitUtility.waitExplicitToBevisibilityOfAllElements(dashboardEventsPageLoad);
		
	}

	public void openTeamsTimeline() {
		
		PageUtility.clickButton(driver, dashboardNewPosts);
		WaitUtility.waitExplicitToBevisibilityOfAllElements(dashboardNewPostsPageLoad);
		
	}

	public void returnHome() {
		
		PageUtility.clickButton(driver, returnDashboard);
		WaitUtility.waitExplicitToBevisibilityOfAllElements(checkDashboardTitle);
		
	}

}
