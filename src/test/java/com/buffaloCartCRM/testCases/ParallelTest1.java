package com.buffaloCartCRM.testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.buffaloCartCRM.base.BaseSetUp;
import com.buffaloCartCRM.constants.Constants;
import com.buffaloCartCRM.pages.DashboardPage;
import com.buffaloCartCRM.pages.LogInPage;
import com.buffaloCartCRM.utils.ExcelRead;

public class ParallelTest1 extends BaseSetUp {
	
	LogInPage logInPage;
	DashboardPage dashboardPage;
	
	@Test(testName = "LogInTestCase",  dataProvider="LogInDetails", priority = 1)
	public void logInTestCase(String emailId, String password) {
		
		logInPage = new LogInPage(driver);
		logInPage.logIn(emailId, password);
		
		SoftAssert valid = new SoftAssert();
		valid.assertEquals(driver.getTitle(),Constants.DASHBOARDTITLE);
		valid.assertAll();

	}
	
	@Test(testName = "DashboardCheckEvents", priority = 2)
	public void dashboardOpenEventTestCase() {
		
		dashboardPage = new DashboardPage(driver);
		dashboardPage.openEvent();
		
		SoftAssert valid = new SoftAssert();
		valid.assertEquals(driver.getTitle(),Constants.EVENTTITLE);
		valid.assertAll();
		
		dashboardPage.returnHome();
		
	}
	
	@Test(testName = "DashboardCheckTask", priority = 3)
	public void dashboardOpenTasksTestCase() {
		
		dashboardPage = new DashboardPage(driver);
		dashboardPage.openTask();
		
		SoftAssert valid = new SoftAssert();
		valid.assertEquals(driver.getTitle(),Constants.TASKSTITLE);
		valid.assertAll();
		
		dashboardPage.returnHome();
		
	}
	
	@DataProvider(name ="LogInDetails")
	public Object[][] LogInDetails() throws IOException, EncryptedDocumentException, InvalidFormatException{
		
		Object[][] data = ExcelRead.getDataFromExcel(Constants.LoginCases, "LogIn");
		return data;
		
	}

}
