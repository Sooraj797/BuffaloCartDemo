package com.buffaloCartCRM.testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.buffaloCartCRM.base.BaseSetUp;
import com.buffaloCartCRM.constants.Constants;
import com.buffaloCartCRM.pages.EventPage;
import com.buffaloCartCRM.utils.ExcelRead;

public class EventPageTestCase extends BaseSetUp {
	
	EventPage eventPage;
	
	@Test(testName = "AddEventTestCase", dataProvider="AddEventDetails", priority = 6)
	public void addEventTestCase(String eventTitle, String eventDescription, String eventLocation, String eventStartDate) {
		
		eventPage = new EventPage(driver);
		boolean ep = eventPage.addEvent(eventTitle, eventDescription, eventLocation, eventStartDate);
		
		SoftAssert addEvent = new SoftAssert();
		addEvent.assertTrue(ep, "Added Event Successfully");
		addEvent.assertAll();
		
	}
	
	@Test(testName = "NavigateEventForwardTestCase", priority = 7)
	public void navigateEventForwardTestCase() {
		
		boolean check = eventPage.navigateEventForward();
		
		SoftAssert checkNav = new SoftAssert();
		checkNav.assertTrue(check, "Navigated Forward");
		checkNav.assertAll();
		
	}
	
	@Test(testName = "NavigateEventBackwardTestCase", priority = 8)
	public void navigateEventBackwardTestCase(){	
		
		boolean check = eventPage.navigateEventBackward();
		
		SoftAssert checkNav = new SoftAssert();
		checkNav.assertTrue(check, "Navigated Backward");
		checkNav.assertAll();
		
	}
	
	@Test(testName = "EventWeekViewTestCase", priority = 9)
	public void eventWeekViewTestCase() {
		
		boolean check = eventPage.eventWeekView();
		
		SoftAssert checkView = new SoftAssert();
		checkView.assertTrue(check, "Week View");
		checkView.assertAll();
	}
	
	@Test(testName = "EventDayViewTestCase", priority = 10)
	public void eventDayViewTestCase() {
		
		boolean check = eventPage.eventDayView();
		
		SoftAssert checkView = new SoftAssert();
		checkView.assertTrue(check, "Week View");
		checkView.assertAll();
	}
	
	@Test(testName = "EventListViewTestCase", priority = 11)
	public void eventListViewTestCase() {
		
		boolean check = eventPage.eventListView();
		
		SoftAssert checkView = new SoftAssert();
		checkView.assertTrue(check, "Week View");
		checkView.assertAll();
	}
	
	@Test(testName = "EventMonthViewTestCase", priority = 12)
	public void eventMonthViewTestCase() {
		
		boolean check = eventPage.eventMonthView();
		
		SoftAssert checkView = new SoftAssert();
		checkView.assertTrue(check, "Month View");
		checkView.assertAll();
		
		eventPage.returnToDashBoard();
		
	}
	
	@DataProvider(name ="AddEventDetails")
	public Object[][] AddEventDetails() throws IOException, EncryptedDocumentException, InvalidFormatException{
		
		Object[][] data = ExcelRead.getDataFromExcel(Constants.EventCases, "AddEvent");
		return data;
		
	}

}
