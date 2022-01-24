package com.buffaloCart.testCases;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Parameters;
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
	
	@Parameters({ "browser" })
	@Test
	public void goToClientTestCase(String browser) {
		clientsPage = new ClientsPage(driver);
		clientsPage.goToClient();
	}
	
	@Parameters({ "browser" })
	@Test
	public void goToContactsTestCase(String browser) {
		clientsPage.goToContacts();
	}
	
	@Parameters({ "browser" })
	@Test
	public void addClientAndContacts(String browser) throws IOException {	
		clients=excelUtility.readExcel(1, "AddClient");
		contacts=excelUtility.readExcel(1, "ClientContacts");

		clientsPage.addClientAndContacts(clients, contacts);	
	}
	
	@Parameters({ "browser" })
	@Test
	public void importClientsTestCase(String browser) {
		clientsPage.importClients();
	}
	
	@Parameters({ "browser" })
	@Test
	public void filteringClientsTestCase(String browser) throws IOException {
		clientsFilter=excelUtility.readExcel(1, "QuickFiltersClient");
		clientsPage.filteringClients(clientsFilter);
	}
	
	@Parameters({ "browser" })
	@Test
	public void downloadExcelContractsTestCase(String browser) throws IOException {
		clientsPage.downloadExcelClientsFile();
	}

}
