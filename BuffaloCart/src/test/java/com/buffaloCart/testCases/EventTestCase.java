package com.buffaloCart.testCases;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.buffaloCart.base.BaseSetUp;
import com.buffaloCart.pages.EventPage;
import com.buffaloCart.pages.LoginPage;
import com.buffaloCart.utils.DataRead;

public class EventTestCase extends BaseSetUp {
	
	DataRead dataRead = new DataRead(driver);
	LoginPage loginPage;
	EventPage eventPage;
	
	ArrayList<String> event;
	String eg;
	
	@Parameters({ "browser" })
	@Test
	public void addEventTestCase(String browser) throws IOException {
		event = new ArrayList<String>();
		eventPage = new EventPage(driver);
		for (int i = 1; i <= 13; i++) {
			eg = dataRead.readStringData(1, i, "AddEvent");
			event.add(eg);
		}
		eventPage.addEvent(event);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Parameters({ "browser" })
	@Test
	public void navigateEventForwardTestCase(String browser) {
		eventPage.navigateEventForward();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Parameters({ "browser" })
	@Test
	public void navigateEventBackwardTestCase(String browser){	
		eventPage.navigateEventBackward();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Parameters({ "browser" })
	@Test
	public void eventWeekViewTestCase(String browser) {
		eventPage.eventWeekView();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Parameters({ "browser" })
	@Test
	public void eventDayViewTestCase(String browser) {
		eventPage.eventDayView();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Parameters({ "browser" })
	@Test
	public void eventListViewTestCase(String browser) {
		eventPage.eventListView();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Parameters({ "browser" })
	@Test
	public void eventMonthViewTestCase(String browser) {
		eventPage.eventMonthView();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

}
