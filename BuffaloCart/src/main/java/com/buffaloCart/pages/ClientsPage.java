package com.buffaloCart.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffaloCart.constants.Constants;
import com.buffaloCart.utils.PageUtility;

public class ClientsPage {
	
	WebDriver driver;
	
	public ClientsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	Constants constants;
	
	ArrayList<WebElement> gender = new ArrayList<WebElement>();
	
	@FindBy(xpath = "//span[text()='Total clients']//parent::div")
	WebElement toTotalClients;
	
	@FindBy(xpath ="//span[text()='Total contacts']//parent::div")
	WebElement toTotalContacts;
	
	@FindBy(xpath = "//a[@title='Add client']")
	WebElement addClient;
	@FindBy(id = "company_name")
	WebElement companyName;
	@FindBy(id = "select2-chosen-15")
	WebElement ownerDropdown;
	@FindBy(id = "s2id_autogen15_search")
	WebElement ownerTextField;
	@FindBy(id = "address")
	WebElement address;
	@FindBy(id = "city")
	WebElement city;
	@FindBy(id = "state")
	WebElement state;
	@FindBy(id = "zip")
	WebElement zip;
	@FindBy(id = "country")
	WebElement country;
	@FindBy(id = "phone")
	WebElement phone;
	@FindBy(id = "website")
	WebElement website;
	@FindBy(id = "vat_number")
	WebElement vatNumber;
	@FindBy(id = "s2id_group_ids")
	WebElement clientGroups;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveButton;
	
	@FindBy(id = "first_name")
	WebElement contactsFirstName;
	@FindBy(id = "last_name")
	WebElement contactsLastName;
	@FindBy(id = "email")
	WebElement contactsEmail;
	@FindBy(id = "phone")
	WebElement contactsPhone;
	@FindBy(id = "skype")
	WebElement contactsSkype;
	@FindBy(id = "job_title")
	WebElement contactsJobTitle;
	@FindBy(id = "gender_male")
	WebElement contactsGenderMale;
	@FindBy(id = "gender_female")
	WebElement contactsGenderFemale;
	@FindBy(id = "login_password")
	WebElement contactsPassword;
	@FindBy(id = "generate_password")
	WebElement contactsGeneratePassword;
	@FindBy(id = "email_login_details")
	WebElement contactsEmailLoginDetails;
	@FindBy(id = "save-and-add-button")
	WebElement contactsSaveAndAddButton;
	@FindBy(xpath = "(//*[contains (text(),'Close')]//parent::div//child::button)[1]")
	WebElement contactsCloseButton;
	
	@FindBy(xpath = "//a[@title='Import clients']")
	WebElement importClientsButton;
	@FindBy(xpath = "//button[text()='Drag-and-drop documents here ']")
	WebElement dragAndDropdocButton;
	
	@FindBy(id = "select2-chosen-12")
	WebElement clientQucikFilterDropdown;
	@FindBy(xpath = "s2id_autogen12_search")
	WebElement clientQucikFilterField;
	
	@FindBy(id = "select2-chosen-4")
	WebElement contactFilterDropdown;
	@FindBy(xpath = "s2id_autogen4_search")
	WebElement contactFilterfield;
	
	
	public void goToClient() {	
		PageUtility.clickButton(driver, toTotalClients);
	}
	
	public void goToContacts() {
		PageUtility.clickButton(driver, toTotalContacts);
	}
	
	public void addClientAndContacts(ArrayList<String> client, ArrayList<String> contact) {
		gender.add(contactsGenderMale);
		gender.add(contactsGenderFemale);
		PageUtility.clickButton(driver, addClient);
		PageUtility.enterText(companyName, client.get(0));
		PageUtility.clickButton(driver, ownerDropdown);
		PageUtility.enterText(ownerTextField, client.get(1));
		PageUtility.enterKey(ownerTextField);
		PageUtility.enterText(address, client.get(2));
		PageUtility.enterText(city, client.get(3));
		PageUtility.enterText(state, client.get(4));
		PageUtility.enterText(zip, client.get(5));
		PageUtility.enterText(country, client.get(6));
		PageUtility.enterText(phone, client.get(7));
		PageUtility.enterText(website, client.get(8));
		PageUtility.enterText(vatNumber, client.get(9));
		PageUtility.enterText(clientGroups, client.get(10));
		PageUtility.enterKey(clientGroups);
		PageUtility.clickButton(driver, saveButton);
		
		PageUtility.enterText(contactsFirstName, contact.get(0));
		PageUtility.enterText(contactsLastName, contact.get(1));
		PageUtility.enterText(contactsEmail, contact.get(2));
		PageUtility.enterText(contactsPhone, contact.get(3));
		PageUtility.enterText(contactsSkype, contact.get(4));
		PageUtility.enterText(contactsJobTitle, contact.get(5));
		if(contact.get(6).equalsIgnoreCase("Male")) {
			PageUtility.clickButton(driver, gender.get(0));
		}else {
			PageUtility.clickButton(driver, gender.get(1));
		}
		if(contact.get(7).equalsIgnoreCase("-")) {
			PageUtility.clickButton(driver, contactsGeneratePassword);
		}else {
			PageUtility.enterText(contactsPassword, contact.get(7));
		}
		PageUtility.clickButton(driver, contactsSaveAndAddButton);
		PageUtility.clickButton(driver, contactsCloseButton);
	}
	
	public void importClients() {
		PageUtility.clickButton(driver, importClientsButton);
		PageUtility.enterText(dragAndDropdocButton, constants.IMPORTCLIENTFILE);
	}
	
	public void filteringClients(ArrayList<String> filter) {
		PageUtility.clickButton(driver, clientQucikFilterDropdown);
		PageUtility.enterText(clientQucikFilterField, filter.get(0));
	}
	
	public void filteringClientGroups(ArrayList<String> filter) {
		PageUtility.clickButton(driver, contactFilterDropdown);
		PageUtility.enterText(contactFilterfield, filter.get(0));
	}

}
