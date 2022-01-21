package com.buffaloCart.testCases;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.buffaloCart.base.BaseSetUp;
import com.buffaloCart.pages.ClientsPage;
import com.buffaloCart.pages.LoginPage;
import com.buffaloCart.utils.DataRead;

public class ClientsTestCase extends BaseSetUp {
	
	DataRead dataRead = new DataRead(driver);
	LoginPage loginPage;
	ClientsPage clientsPage = new ClientsPage(driver);
	
	String eg1;
	String eg2;
	
	ArrayList<String> clients = new ArrayList<String>();
	ArrayList<String> contacts = new ArrayList<String>();
	
	ArrayList<String> clientsFilter = new ArrayList<String>();
	ArrayList<String> clientsGroupFilter = new ArrayList<String>();
	
	
	public void goToClientTestCase(String browser) {
		clientsPage.goToClient();
	}
	
	
	public void goToContactsTestCase(String browser) {
		clientsPage.goToContacts();
	}
	
	
	public void addClientAndContacts(String browser) throws IOException {	
		for (int i = 1; i <= 16; i++) {
			eg1 = dataRead.readStringData(1, i, "AddClient");
			clients.add(eg1);
		}
		for (int i = 1; i <= 16; i++) {
			eg2 = dataRead.readStringData(1, i, "ClientContacts");
			contacts.add(eg2);
		}
		clientsPage.addClientAndContacts(clients, contacts);	
	}
	
	
	public void importClientsTestCase(String browser) {
		clientsPage.importClients();
	}
	
	
	public void filteringClientsTestCase(String browser) throws IOException {
		for (int i = 1; i <= 16; i++) {
			eg1 = dataRead.readStringData(1, i, "QuickFilterClient");
			clientsFilter.add(eg1);
		}
		clientsPage.filteringClients(clientsFilter);
	}
	
	
	public void filteringContacts(String browser) throws IOException {
		for (int i = 1; i <= 16; i++) {
			eg2 = dataRead.readStringData(1, i, "FilterClientGroup");
			clientsGroupFilter.add(eg2);
		}
		clientsPage.filteringClientGroups(clientsGroupFilter);
	}

}
