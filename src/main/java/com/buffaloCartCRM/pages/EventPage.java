package com.buffaloCartCRM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffaloCartCRM.utils.PageUtility;
import com.buffaloCartCRM.utils.WaitUtility;

public class EventPage {
	
	WebDriver driver;
	
	public EventPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver;
		
	}
	@FindBy(xpath = "//span[text()='Dashboard']")
	WebElement goToDashboardPage;
	
	@FindBy(xpath = "//span[text()='Events']//parent::a")
	WebElement goToEvents;
	@FindBy(xpath = "(//a[@title='Add event'])[2]")
	WebElement eventAddEvent;
	
	@FindBy(id = "title")
	WebElement title;
	@FindBy(id = "description")
	WebElement description;
	@FindBy(id = "location")
	WebElement location;
	@FindBy(id = "start_date")
	WebElement startDate;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveButton;
	
	@FindBy(xpath="//*[contains(text(), 'Meeting')]")
	WebElement eventtitle;
	
	@FindBy(xpath = "(//*[contains (text(),'month')]//parent::div//child::button)[1]")
	WebElement eventMonthView;
	@FindBy(xpath = "(//*[contains (text(),'week')]//parent::div//child::button)[2]")
	WebElement eventWeekView;
	@FindBy(xpath = "(//*[contains (text(),'day')]//parent::div//child::button)[3]")
	WebElement eventDayView;
	@FindBy(xpath = "(//*[contains (text(),'list')]//parent::div//child::button)[4]")
	WebElement eventListView;
	
	@FindBy(xpath = "(//button[@type='button']//parent::div//child::button)[2]")
	WebElement eventForwardNavigation;
	@FindBy(xpath = "//*[contains (text(),'April 2022')]")
	WebElement validEventForwardNavigation;
	
	@FindBy(xpath = "(//button[@type='button']//parent::div//child::button)[1]")
	WebElement eventBackwardNavigation;
	@FindBy(xpath = "//*[contains (text(),'March 2022')]")
	WebElement validEventBackwardNavigation;
	
	@FindBy(xpath = "//h1[text()='Event calendar']")
	WebElement eventFinalEventPage;
	
	@FindBy(xpath = "//span[text()='Dashboard']//parent::a")
	WebElement eventReturnDashboard;
	
	public boolean addEvent(String eventTitle, String eventDescription, String eventLocation, String eventStartDate) {
		
		System.out.println(eventStartDate);
		
		PageUtility.clickButton(driver, goToEvents);
		
		WaitUtility.waitExplicitToBeClickable(eventAddEvent);
		PageUtility.clickButton(driver, eventAddEvent);
		
		PageUtility.enterText(title, eventTitle);
		WaitUtility.waitImplicit(4);
		PageUtility.enterText(description, eventDescription);
		
		PageUtility.clickActionButton(driver, location);
		PageUtility.enterText(location, eventLocation);
		
		PageUtility.clickButton(driver, startDate);
		PageUtility.enterText(startDate, eventStartDate);
		PageUtility.enterKey(startDate);
		
		WaitUtility.waitExplicitToBeClickable(saveButton);
		PageUtility.clickButton(driver, saveButton);
		WaitUtility.waitExplicitToBevisibilityOfAllElements(eventtitle);
		Boolean a=PageUtility.displayed(eventtitle);
		WaitUtility.waitImplicit(5);
		
		return a;

	}
	
	public boolean eventMonthView() {
		WaitUtility.waitExplicitToBeClickable(eventMonthView);
		PageUtility.clickButton(driver, eventMonthView);
		WaitUtility.waitImplicit(5);
		boolean b = PageUtility.enabled(eventMonthView);
		System.out.println(b);
		return b;
	}
	
	public boolean eventWeekView() {
		WaitUtility.waitExplicitToBeClickable(eventWeekView);
		PageUtility.clickButton(driver, eventWeekView);
		WaitUtility.waitImplicit(5);
		boolean b = PageUtility.enabled(eventWeekView);
		System.out.println(b);
		return b;
	}
	
	public boolean eventDayView() {
		WaitUtility.waitExplicitToBeClickable(eventDayView);
		PageUtility.clickButton(driver, eventDayView);
		WaitUtility.waitImplicit(5);
		boolean b = PageUtility.enabled(eventDayView);
		System.out.println(b);
		return b;
	}
	
	public boolean eventListView() {
		WaitUtility.waitExplicitToBeClickable(eventListView);
		PageUtility.clickButton(driver, eventListView);
		WaitUtility.waitImplicit(5);
		boolean b = PageUtility.enabled(eventListView);
		System.out.println(b);
		return b;
	}
	
	public boolean navigateEventForward() {
		PageUtility.clickButton(driver, eventForwardNavigation);
		WaitUtility.waitImplicit(5);
		boolean valid = PageUtility.displayed(validEventForwardNavigation);
		return valid;
	}
	
	public boolean navigateEventBackward() {
		PageUtility.clickButton(driver, eventBackwardNavigation);
		WaitUtility.waitImplicit(5);
		boolean valid = PageUtility.displayed(validEventBackwardNavigation);
		return valid;
	}
	
	public void returnToDashBoard() {
		
		PageUtility.clickButton(driver, goToDashboardPage);
		
	}

}
