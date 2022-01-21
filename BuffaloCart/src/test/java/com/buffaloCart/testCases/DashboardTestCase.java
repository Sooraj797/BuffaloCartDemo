package com.buffaloCart.testCases;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.buffaloCart.base.BaseSetUp;
import com.buffaloCart.pages.DashboardPage;
import com.buffaloCart.pages.LoginPage;
import com.buffaloCart.utils.DataRead;

public class DashboardTestCase extends BaseSetUp {

	DataRead dataRead = new DataRead(driver);
	LoginPage loginPage = new LoginPage(driver);
	DashboardPage dashboardPage;

	@Test
	@Parameters({ "browser" }) 
	public void dashboardTestCase(String browser) throws IOException {

		dashboardPage = new DashboardPage(driver);
		dashboardPage.clockIN();
		dashboardPage.openEvent();
		dashboardPage.returnHome();
		dashboardPage.openTasks();
		dashboardPage.returnHome();
		dashboardPage.openTeamsTimeline();
		dashboardPage.returnHome();

	}

}
