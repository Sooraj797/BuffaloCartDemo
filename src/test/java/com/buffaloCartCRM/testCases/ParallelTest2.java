package com.buffaloCartCRM.testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.buffaloCartCRM.base.BaseSetUp;
import com.buffaloCartCRM.constants.Constants;
import com.buffaloCartCRM.pages.DashboardPage;
import com.buffaloCartCRM.pages.LogInPage;

public class ParallelTest2 extends BaseSetUp{

	LogInPage logInPage;
	DashboardPage dashboardPage;
	
	@Test(testName = "LogInTestCase",  dataProvider="LogInDetails", priority = 4)
	public void logInTestCase(String emailId, String password) {
		
		logInPage = new LogInPage(driver);
		logInPage.logIn(emailId, password);
		
		SoftAssert valid = new SoftAssert();
		valid.assertEquals(driver.getTitle(),Constants.DASHBOARDTITLE);
		valid.assertAll();

	}
	
	@Test(testName = "DashboardClockIn", priority = 5)
	public void dashboardClockInTestCase() {
		
		dashboardPage = new DashboardPage(driver);

		boolean clock = dashboardPage.clockIn();
		
		SoftAssert clockIn = new SoftAssert();
		clockIn.assertTrue(clock, "Clocked In Successfully");
		clockIn.assertAll();
		
	}
	
	
	@Test(testName = "DashboardCheckTeam", priority =6)
	public void dashboardOpenTeamsTimelineTestCase() {
		
		dashboardPage = new DashboardPage(driver);
		dashboardPage.openTeamsTimeline();
		
		SoftAssert valid = new SoftAssert();
		valid.assertEquals(driver.getTitle(),Constants.TIMELINETITLE);
		valid.assertAll();
		
		dashboardPage.returnHome();
		
	}

}
