package com.buffaloCart.testCases;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.buffaloCart.base.BaseSetUp;
import com.buffaloCart.pages.CreateAccountPage;
import com.buffaloCart.pages.LoginPage;
import com.buffaloCart.utils.DataRead;

public class CreateAccountTestCase extends BaseSetUp {
	
	DataRead dataRead = new DataRead(driver);
	LoginPage loginPage;
	CreateAccountPage createAccount;
	
	String eg;
	ArrayList<String> list;
	
	public void createAccountTestCase(String browser) throws IOException {

		list = new ArrayList<String>();
		createAccount = new CreateAccountPage(driver);
		for (int i = 1; i <= 6; i++) {
			eg = dataRead.readStringData(1, i, "CreateAccount");
			list.add(eg);
		}
		createAccount.createAccount(list);

	}

}
