package com.buffaloCart.testCases;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Test;

import com.buffaloCart.base.BaseSetUp;
import com.buffaloCart.pages.ClientsPage;
import com.buffaloCart.pages.LoginPage;
import com.buffaloCart.utils.DataRead;
import com.buffaloCart.utils.ExcelUtility;

public class ClientsTestCase extends BaseSetUp {
	
	DataRead dataRead = new DataRead(driver);
	ExcelUtility excelUtility = new ExcelUtility();
	LoginPage loginPage;
	ClientsPage clientsPage;
	
	ArrayList<String> clients = new ArrayList<String>();
	ArrayList<String> contacts = new ArrayList<String>();
	
	ArrayList<String> clientsFilter = new ArrayList<String>();
	
	@Test
	public void goToClientTestCase() {
		clientsPage = new ClientsPage(driver);
		clientsPage.goToClient();
	}
	
	@Test
	public void goToContactsTestCase() {
		clientsPage.goToContacts();
	}
	
	@Test
	public void addClientAndContacts() throws IOException {	
		clients=excelUtility.readExcel(1, "AddClient");
		contacts=excelUtility.readExcel(1, "ClientContacts");

		clientsPage.addClientAndContacts(clients, contacts);	
	}
	
	/*
	 * @Test public void filteringClientsTestCase() throws IOException {
	 * clientsFilter=excelUtility.readExcel(1, "QuickFiltersClient");
	 * clientsPage.filteringClients(clientsFilter); }
	 */
	
	@Test
	public void downloadExcelContractsTestCase() throws IOException {
		clientsPage.downloadExcelClientsFile();
	}

}
