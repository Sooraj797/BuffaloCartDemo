package com.buffaloCart.testCases;

import org.testng.annotations.Parameters;
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
	@Parameters({ "browser" }) 
	public void clockINTestCase(String browser) {
		dashboardPage = new DashboardPage(driver);
		dashboardPage.clockIN();
	}
	
	@Test
	@Parameters({ "browser" }) 
	public void openEventTestCase(String browser) {
		dashboardPage.openEvent();
		dashboardPage.returnHome();
	}
	
	@Test
	@Parameters({ "browser" }) 
	public void openTasksTestCase(String browser) {
		dashboardPage.openTasks();
		dashboardPage.returnHome();
	}
	
	@Test
	@Parameters({ "browser" }) 
	public void openTeamsTimelineTestCase(String browser) {
		dashboardPage.openTeamsTimeline();
		dashboardPage.returnHome();
	}
		
		
}
