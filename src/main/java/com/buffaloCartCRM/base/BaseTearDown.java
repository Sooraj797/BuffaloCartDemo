package com.buffaloCartCRM.base;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;

public class BaseTearDown extends BaseSetUp {

	@AfterClass(alwaysRun = true)
	public void closeUp(ITestResult result) throws IOException {

		driver.close();

	}

}
