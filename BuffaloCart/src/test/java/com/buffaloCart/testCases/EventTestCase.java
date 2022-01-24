package com.buffaloCart.testCases;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.buffaloCart.base.BaseSetUp;
import com.buffaloCart.pages.EventPage;
import com.buffaloCart.pages.LoginPage;
import com.buffaloCart.utils.DataRead;
import com.buffaloCart.utils.ExcelUtility;

public class EventTestCase extends BaseSetUp {
	
	DataRead dataRead = new DataRead(driver);
	ExcelUtility excelUtility = new ExcelUtility();
	LoginPage loginPage;
	EventPage eventPage;
	
	ArrayList<String> event;
	String eg;
	
	@Parameters({ "browser" })
	@Test
	public void addEventTestCase(String browser) throws IOException {
		event = new ArrayList<String>();
		eventPage = new EventPage(driver);
		event=excelUtility.readExcel(1, "AddEvent");
		eventPage.addEvent(event);
	}
	
	@Parameters({ "browser" })
	@Test
	public void navigateEventForwardTestCase(String browser) {
		eventPage.navigateEventForward();	
	}
	
	@Parameters({ "browser" })
	@Test
	public void navigateEventBackwardTestCase(String browser){	
		eventPage.navigateEventBackward();
	}
	
	@Parameters({ "browser" })
	@Test
	public void eventWeekViewTestCase(String browser) {
		eventPage.eventWeekView();
	}
	
	@Parameters({ "browser" })
	@Test
	public void eventDayViewTestCase(String browser) {
		eventPage.eventDayView();
	}
	
	@Parameters({ "browser" })
	@Test
	public void eventListViewTestCase(String browser) {
		eventPage.eventListView();
	}
	
	@Parameters({ "browser" })
	@Test
	public void eventMonthViewTestCase(String browser) {
		eventPage.eventMonthView();
	}

}
