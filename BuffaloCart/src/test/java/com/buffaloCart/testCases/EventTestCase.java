package com.buffaloCart.testCases;

import java.io.IOException;
import java.util.ArrayList;

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
	
	@Test
	public void addEventTestCase() throws IOException {
		event = new ArrayList<String>();
		eventPage = new EventPage(driver);
		event=excelUtility.readExcel(1, "AddEvent");
		eventPage.addEvent(event);
	}
	
	@Test
	public void navigateEventForwardTestCase() {
		eventPage.navigateEventForward();	
	}
	
	@Test
	public void navigateEventBackwardTestCase(){	
		eventPage.navigateEventBackward();
	}
	
	@Test
	public void eventWeekViewTestCase() {
		eventPage.eventWeekView();
	}
	
	@Test
	public void eventDayViewTestCase() {
		eventPage.eventDayView();
	}
	
	@Test
	public void eventListViewTestCase() {
		eventPage.eventListView();
	}
	
	@Test
	public void eventMonthViewTestCase() {
		eventPage.eventMonthView();
	}

}
