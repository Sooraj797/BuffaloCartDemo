package com.buffaloCart.testCases;

import org.testng.annotations.Test;

import com.buffaloCart.base.BaseSetUp;
import com.buffaloCart.pages.DashboardPage;
import com.buffaloCart.pages.LoginPage;
import com.buffaloCart.utils.DataRead;

public class DashboardTestCase extends BaseSetUp {

	DataRead dataRead = new DataRead(driver);
	LoginPage loginPage;
	DashboardPage dashboardPage;

	@Test
	public void clockINTestCase() {
		dashboardPage = new DashboardPage(driver);
		dashboardPage.clockIN();
	}
	
	@Test
	public void openEventTestCase() {
		dashboardPage.openEvent();
		dashboardPage.returnHome();
	}
	
	@Test
	public void openTasksTestCase() {
		dashboardPage.openTasks();
		dashboardPage.returnHome();
	}
	
	@Test
	public void openTeamsTimelineTestCase() {
		dashboardPage.openTeamsTimeline();
		dashboardPage.returnHome();
	}
		
		
}
