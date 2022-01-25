package com.buffaloCart.testCases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.buffaloCart.base.BaseSetUp;
import com.buffaloCart.pages.LoginPage;
import com.buffaloCart.utils.DataRead;

public class LogInTestCase extends BaseSetUp {

	DataRead dataRead;
	LoginPage loginPage;

	String emailId;
	String password;

	@Test
	public void logInTestCase() throws IOException {

		dataRead = new DataRead(driver);
		emailId = dataRead.readStringData(1, 1, "LogIn");
		password = dataRead.readStringData(1, 2, "LogIn");
		
		loginPage = new LoginPage(driver);
		boolean auth = loginPage.logIn(emailId, password);
		
		SoftAssert softAssert = new SoftAssert(); 
		softAssert.assertTrue(auth,"Credentials is Wrong");
		System.out.println("Wrong login credentials is entered");
		softAssert.assertAll();

	}


}
