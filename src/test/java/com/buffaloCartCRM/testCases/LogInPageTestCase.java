package com.buffaloCartCRM.testCases;

import com.buffaloCartCRM.constants.Constants;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.buffaloCartCRM.base.BaseSetUp;
import com.buffaloCartCRM.pages.LogInPage;
import com.buffaloCartCRM.utils.ExcelRead;

public class LogInPageTestCase extends BaseSetUp {
	
	LogInPage logInPage;
	
	@Test(testName = "LogInTestCase",  dataProvider="LogInDetails", groups= {"Sanity Test"}, priority = 1)
	public void logInTestCase(String emailId, String password) {
		
		logInPage = new LogInPage(driver);
		logInPage.logIn(emailId, password);
		
		SoftAssert valid = new SoftAssert();
		valid.assertEquals(driver.getTitle(),Constants.DASHBOARDTITLE);
		valid.assertAll();

	}
	
	@DataProvider(name ="LogInDetails")
	public Object[][] LogInDetails() throws IOException, EncryptedDocumentException, InvalidFormatException{
		
		Object[][] data = ExcelRead.getDataFromExcel(Constants.LoginCases, "LogIn");
		return data;
		
	}

}
