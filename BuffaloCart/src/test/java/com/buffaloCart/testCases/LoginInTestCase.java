package com.buffaloCart.testCases;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.buffaloCart.base.BaseSetUp;
import com.buffaloCart.pages.LoginPage;
import com.buffaloCart.utils.DataRead;

public class LoginInTestCase extends BaseSetUp {

	DataRead dataRead;
	LoginPage loginPage;

	String emailId;
	String password;

	@Parameters({ "browser" })
	@Test
	public void logInTestCase(String browser) throws IOException {

		dataRead = new DataRead(driver);
		emailId = dataRead.readStringData(1, 1, "LogIn");
		password = dataRead.readStringData(1, 2, "LogIn");
		
		loginPage = new LoginPage(driver);
		loginPage.logIn(emailId, password);

	}


}
