package com.buffaloCart.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.buffaloCart.base.BaseSetUp;
import com.buffaloCart.pages.ForgotPasswordPage;
import com.buffaloCart.pages.LoginPage;
import com.buffaloCart.utils.DataRead;

public class ForgotPasswordTestCase extends BaseSetUp {
	
	DataRead dataRead = new DataRead(driver);
	LoginPage loginPage;
	ForgotPasswordPage forgotPasswordPage;
	
	@Test
	public void forgotPasswordTestCase() throws IOException {
		forgotPasswordPage = new ForgotPasswordPage(driver);
		forgotPasswordPage.forgotPassword();
	}

}
