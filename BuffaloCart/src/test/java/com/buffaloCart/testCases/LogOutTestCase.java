package com.buffaloCart.testCases;

import org.testng.annotations.Test;

import com.buffaloCart.base.BaseSetUp;
import com.buffaloCart.pages.DashboardPage;
import com.buffaloCart.pages.LogOutPage;


public class LogOutTestCase extends BaseSetUp{
	
	LogOutPage logOutPage;
	DashboardPage dashboardPage;
	
	@Test
	public void clockOutTestCase() {
		logOutPage = new LogOutPage(driver);
		logOutPage.clockOut();
	}
	
	@Test
	public void logOutTestCase() {
		logOutPage.logOut();
	}

}
