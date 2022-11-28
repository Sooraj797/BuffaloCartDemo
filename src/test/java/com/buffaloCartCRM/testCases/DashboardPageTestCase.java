package com.buffaloCartCRM.testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.buffaloCartCRM.base.BaseSetUp;
import com.buffaloCartCRM.constants.Constants;
import com.buffaloCartCRM.pages.DashboardPage;

public class DashboardPageTestCase extends BaseSetUp {
	
	DashboardPage dashboardPage;
	
	@Test(testName = "DashboardClockIn", groups= {"Sanity Test"}, priority = 2)
	public void dashboardClockInTestCase() {
		
		dashboardPage = new DashboardPage(driver);

		boolean clock = dashboardPage.clockIn();
		
		SoftAssert clockIn = new SoftAssert();
		clockIn.assertTrue(clock, "Clocked In Successfully");
		clockIn.assertAll();
		
	}
	
	@Test(testName = "DashboardCheckEvents", groups= {"Sanity Test"}, priority = 3)
	public void dashboardOpenEventTestCase() {
		
		dashboardPage.openEvent();
		
		SoftAssert valid = new SoftAssert();
		valid.assertEquals(driver.getTitle(),Constants.EVENTTITLE);
		valid.assertAll();
		
		dashboardPage.returnHome();
		
	}
	
	@Test(testName = "DashboardCheckTask", groups= {"Sanity Test"}, priority = 4)
	public void dashboardOpenTasksTestCase() {
		
		dashboardPage.openTask();
		
		SoftAssert valid = new SoftAssert();
		valid.assertEquals(driver.getTitle(),Constants.TASKSTITLE);
		valid.assertAll();
		
		dashboardPage.returnHome();
		
	}
	
	@Test(testName = "DashboardCheckTeam", groups= {"Sanity Test"}, priority =5)
	public void dashboardOpenTeamsTimelineTestCase() {
		
		dashboardPage.openTeamsTimeline();
		
		SoftAssert valid = new SoftAssert();
		valid.assertEquals(driver.getTitle(),Constants.TIMELINETITLE);
		valid.assertAll();
		
		dashboardPage.returnHome();
		
	}

}
