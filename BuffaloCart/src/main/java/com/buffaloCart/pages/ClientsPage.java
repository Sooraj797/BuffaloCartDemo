package com.buffaloCart.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffaloCart.constants.Constants;
import com.buffaloCart.utils.PageUtility;
import com.buffaloCart.utils.WaitUtility;

public class ClientsPage {
	
	WebDriver driver;
	
	public ClientsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	Constants constants = new Constants();
	
	ArrayList<WebElement> gender = new ArrayList<WebElement>();
	
	@FindBy(xpath = "//span[text()='Clients']")
	WebElement mainClient;
	
	@FindBy(xpath = "//a[text()='Overview']")
	WebElement toOverviewPage;
	
	@FindBy(xpath = "//span[text()='Total clients']//parent::div")
	WebElement toTotalClients;
	@FindBy(xpath = "(//th[text()='Company name'])[1]")
	WebElement findCompanyName;
	
	@FindBy(xpath ="//span[text()='Total contacts']//parent::div")
	WebElement toTotalContacts;
	@FindBy(xpath = "(//th[text()='Name'])[1]")
	WebElement findName;
	
	@FindBy(xpath = "//a[text()='Clients']")
	WebElement clientsFrame;
	
	@FindBy(xpath = "//a[@title='Add client']")
	WebElement addClient;
	
	@FindBy(id = "company_name")
	WebElement companyName;
	
	@FindBy(xpath = "//div[@class='form-group']//parent::div//child::div//child::label//following-sibling::div//child::div//child::a")
	WebElement ownerDropdown;
	@FindBy(xpath = "(//div[@class='select2-search']//parent::div//child::input)[5]")
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
	
	@FindBy(id = "save-and-continue-button")
	WebElement saveAndContinueButton;
	
	@FindBy(xpath = "//h4[text()='Add multiple contacts']")
	WebElement waitNextContactsTab;
	
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
	
	@FindBy(xpath = "//a[text()=' Import clients']//parent::a")
	WebElement importClientsButton;
	@FindBy(xpath = "//h4[text()='Import clients']")
	WebElement importClientsTitle;
	@FindBy(xpath = "//button[text()='Drag-and-drop documents here ']")
	WebElement dragAndDropdocButton;
	@FindBy(xpath = "//button[text()=' Next']")
	WebElement importNext;
	@FindBy(xpath = "//button[text()=' Upload']")
	WebElement importUpload;
	
	@FindBy(xpath = "(//div[@class='mr15 DTTT_container']//parent::div//child::div//child::a)[2]")
	WebElement clientQucikFilterDropdown;
	@FindBy(xpath = "(//div[@class='select2-search']//parent::div//child::div//child::label//following-sibling::input)[4]")
	WebElement clientQucikFilterField;
	
	@FindBy(xpath = "//span[text()='Excel']")
	WebElement clientExcelButon;
	
	public void goToClient() {	
		PageUtility.clickButton(driver, mainClient);
		PageUtility.clickButton(driver, toTotalClients);
		WaitUtility.waitExplicitToBevisibilityOfAllElements(findCompanyName);
		WaitUtility.waitExplicitToBeClickable(toOverviewPage);
		PageUtility.clickButton(driver, toOverviewPage);
	}
	
	public void goToContacts() {
		PageUtility.clickButton(driver, toTotalContacts);
		WaitUtility.waitExplicitToBevisibilityOfAllElements(findName);
		WaitUtility.waitExplicitToBeClickable(toOverviewPage);
		PageUtility.clickButton(driver, toOverviewPage);
		WaitUtility.waitExplicitToBevisibilityOfAllElements(toTotalClients);
	}
	
	public void addClientAndContacts(ArrayList<String> client, ArrayList<String> contact) {
		gender.add(contactsGenderMale);
		gender.add(contactsGenderFemale);
		
		PageUtility.clickButton(driver, clientsFrame);
		WaitUtility.waitExplicitToBevisibilityOfAllElements(findCompanyName);
		
		WaitUtility.waitExplicitToBeClickable(addClient);
		PageUtility.clickButton(driver, addClient);
		
		PageUtility.enterText(companyName, client.get(1));
			
		PageUtility.clickActionButton(driver, ownerDropdown);
		PageUtility.enterText(ownerTextField, client.get(2));
		PageUtility.enterKey(ownerTextField);
		
		PageUtility.enterText(address, client.get(3));
		PageUtility.enterText(city, client.get(4));
		PageUtility.enterText(state, client.get(5));
		PageUtility.enterText(zip, client.get(6));
		PageUtility.enterText(country, client.get(7));
		
		PageUtility.enterText(phone, client.get(8));
		
		PageUtility.enterText(website, client.get(9));
		
		PageUtility.enterText(vatNumber, client.get(10));
		
		/*
		 * PageUtility.enterText(clientGroups, client.get(11));
		 * PageUtility.enterKey(clientGroups);
		 */
		WaitUtility.waitExplicitToBeClickable(saveAndContinueButton);
		PageUtility.clickButton(driver, saveAndContinueButton);
		
		WaitUtility.waitExplicitToBevisibilityOfAllElements(waitNextContactsTab);
		WaitUtility.waitImplicit(4);
		
		PageUtility.enterText(contactsFirstName, contact.get(1));
		PageUtility.enterText(contactsLastName, contact.get(2));
		
		PageUtility.enterText(contactsEmail, contact.get(3));
		
		PageUtility.enterText(contactsPhone, contact.get(4));
		
		PageUtility.enterText(contactsSkype, contact.get(5));
		
		PageUtility.enterText(contactsJobTitle, contact.get(6));
			
		if(contact.get(7).equalsIgnoreCase("Male")) {
			PageUtility.clickButton(driver, gender.get(0));
		}else {
			PageUtility.clickButton(driver, gender.get(1));
		}
			
		if(contact.get(7).equalsIgnoreCase("-")) {
			PageUtility.clickActionButton(driver, contactsGeneratePassword);
		}else {
			PageUtility.clickActionButton(driver, contactsPassword);
			PageUtility.enterText(contactsPassword, contact.get(8));
		}
		
		WaitUtility.waitExplicitToBeClickable(contactsSaveAndAddButton);
		PageUtility.clickButton(driver, contactsSaveAndAddButton);
		WaitUtility.waitExplicitToBeClickable(contactsCloseButton);
		PageUtility.clickButton(driver, contactsCloseButton);
	}
	
	public void importClients() {
		//WaitUtility.waitExplicitToBevisibilityOfAllElements(findCompanyName);
		//WaitUtility.waitImplicit(10);
		PageUtility.clickActionButton(driver, importClientsButton);
		//WaitUtility.waitExplicitToBevisibilityOfAllElements(importClientsTitle);
		PageUtility.enterText(dragAndDropdocButton, constants.IMPORTCLIENTFILE);
		PageUtility.clickActionButton(driver, importNext);
		PageUtility.clickActionButton(driver, importUpload);
		PageUtility.clickActionButton(driver, clientsFrame);
		//WaitUtility.waitExplicitToBevisibilityOfAllElements(clientsFrame);
	}
	
	public void filteringClients(ArrayList<String> filter) {
		PageUtility.clickActionButton(driver, clientQucikFilterDropdown);
		PageUtility.enterText(clientQucikFilterField, filter.get(1));
		PageUtility.enterKey(clientQucikFilterField);
	}
	
	public void downloadExcelClientsFile() {
		PageUtility.clickButton(driver, clientExcelButon);
	}

}
