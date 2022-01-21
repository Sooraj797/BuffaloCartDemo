package com.buffaloCart.testCases;

import java.io.IOException;
import java.util.ArrayList;

import com.buffaloCart.base.BaseSetUp;
import com.buffaloCart.pages.LoginPage;
import com.buffaloCart.pages.SalesPage;
import com.buffaloCart.utils.DataRead;

public class SalesTestCase extends BaseSetUp {
	
	DataRead dataRead = new DataRead(driver);
	LoginPage loginPage;
	SalesPage salesPage = new SalesPage(driver);
	
	String eg1;
	String eg2;
	
	ArrayList<String> contracts = new ArrayList<String>();
	ArrayList<String> items = new ArrayList<String>();
	
	ArrayList<String> filtercontracts = new ArrayList<String>();
	ArrayList<String> filteritems = new ArrayList<String>();
	
	public void addContractsTestCase(String browser) throws IOException {
		salesPage.salesOptionDropdown();
		for (int i = 1; i <= 16; i++) {
			eg1 = dataRead.readStringData(1, i, "AddContract");
			contracts.add(eg1);
		}
		salesPage.addContracts(contracts);
	}
	
	public void filteringContractsStatusTestCase(String browser) {
		salesPage.filteringContractsStatus(filtercontracts);
	}
	
	public void downloadExcelContractsTestCase(String browser) {
		salesPage.downloadExcelContracts();
	}
	
	public void navigateContractsTestCase(String browser) {
		salesPage.navigateContractForward();
		salesPage.navigateContractBackward();
	}
	
	public void addItemTestCase(String browser) throws IOException {
		for (int i = 1; i <= 16; i++) {
			eg2 = dataRead.readStringData(1, i, "AddItem");
			items.add(eg2);
		}
		salesPage.addItems(items);
	}
	
	public void filteringItemsCategoryTestcase(String browser) {
		salesPage.filteringItemsCategory(filteritems);
	}
	
	public void storeAddToCartTestCase(String browser) {
		salesPage.storeAddToCart();
	}
	
	public void storesPlaceOrderTestCase(String browser) {
		salesPage.storesPlaceOrder();
	}

}
