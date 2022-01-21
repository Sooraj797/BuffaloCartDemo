package com.buffaloCart.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffaloCart.utils.PageUtility;

public class SalesPage {
	
	WebDriver driver;
	
	public SalesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//*[contains (text(),'Sales')]")
	WebElement salesPageButton;
	
	@FindBy(xpath = "//*[contains (text(),'Contracts')]//parent::span")
	WebElement salesContractPageButton;
	@FindBy(xpath = "//a[@title='Add contract']")
	WebElement contractsAddContractButton;
	@FindBy(id = "title")
	WebElement contractsTitle;
	@FindBy(id = "contract_date")
	WebElement contractsStartDate;
	@FindBy(id = "valid_until")
	WebElement contractsValidDate;
	
	@FindBy(xpath = "//*[contains (text(),'Client/Lead')]//following-sibling::div//child::div//child::a")
	WebElement contractClientDropdown;
	@FindBy(xpath = "(//*[contains (text(),'Client/Lead')]//following-sibling::input)[2]")
	WebElement contractClientTextField;
	
	@FindBy(xpath = "//*[contains (text(),'Project')]//following-sibling::div//child::div//child::a")
	WebElement contractProjectDropdown;
	@FindBy(xpath = "(//*[contains (text(),'Project')]//following-sibling::input)[2]")
	WebElement contractProjectTextField;
	
	@FindBy(xpath = "(//*[contains (text(),'TAX')]//following-sibling::div//child::div//child::a)[1]")
	WebElement contractTaxDropdown;
	@FindBy(xpath = "(//*[contains (text(),'TAX')]//following-sibling::input)[2]")
	WebElement contractTaxTextField;
	
	@FindBy(xpath = "//*[contains (text(),'Second TAX')]//following-sibling::div//child::div//child::a")
	WebElement contractSecondTaxDropdown;
	@FindBy(xpath = "(//div[@class='select2-drop select2-display-none select2-with-searchbox select2-drop-active']//parent::div//child::div//child::input)[4]")
	WebElement contractSecondTaxTextField;
	
	@FindBy(id = "contract_note")
	WebElement contractNote;
	@FindBy(xpath = "//*[contains (text(), 'Save')]")
	WebElement contractSaveButton;
	
	@FindBy(xpath = "	")
	WebElement contractsStatusFilterDropdown;
	@FindBy(xpath = "(//div[@class='select2-drop select2-display-none select2-with-searchbox select2-drop-active']//parent::div//child::input)")
	WebElement  contractsStatusFilterSelect;
	
	@FindBy(xpath = "//span[text()='Excel']")
	WebElement contractsExcelDownloadButton;
	
	@FindBy(xpath = "(//div[@class='mr15 DTTT_container']//child::button)[3]")
	WebElement contractsForwardNavigation;
	@FindBy(xpath = "(//div[@class='mr15 DTTT_container']//child::button)[1]")
	WebElement contractsBackwardNavigation;
	
	@FindBy(xpath = "//span[text()='Items']")
	WebElement itemsPageButton;
	@FindBy(xpath = "//a[@title='Add item']")
	WebElement itemsAddItemButton;
	@FindBy(id = "title")
	WebElement itemsTitle;
	@FindBy(id = "description")
	WebElement itemsDescription;
	@FindBy(xpath = "(//label[@for='category_id']//parent::div//child::span)")
	WebElement itemsCategoryDropdown;
	@FindBy(xpath = "(//div[@class='select2-drop select2-display-none select2-with-searchbox select2-drop-active']//child::input)")
	WebElement itemsCategoryTextField;
	@FindBy(id = "unti_type")
	WebElement itemsUntiType;
	@FindBy(id = "item_rate")
	WebElement itemsRate;
	@FindBy(id = "show_in_client_portal")
	WebElement itemsShowInPortal;
	@FindBy(xpath = "//*[contains (text(), 'Save')]")
	WebElement itemsSaveButton;
	
	@FindBy(xpath = "(//*[contains (text(), 'Category')]//parent::a)")
	WebElement itemsFilterCategoryDropdown;
	@FindBy(xpath = "(//div[@class='select2-drop select2-display-none select2-with-searchbox select2-drop-active']//child::input)[2]")
	WebElement itemsFilterCategoryTextField;
	
	@FindBy(xpath = "(//span[text()='Store'])")
	WebElement storePageButton;
	@FindBy(xpath = "(//a[text()='Add to cart'])")
	WebElement storeToCartButton;
	
	@FindBy(id = "js-cart-min-icon")
	WebElement storesCartIconButton;
	@FindBy(xpath = "(//*[contains (text(), 'Process Order')])")
	WebElement storesProcessOrderButton;
	@FindBy(xpath = "(//*[contains (text(), 'Place order')])")
	WebElement storesPlaceOrderButton;
	
	public void salesOptionDropdown() {
		PageUtility.clickButton(driver, salesPageButton);
	}
	
	public void addContracts(ArrayList<String> contract) {
		PageUtility.clickButton(driver, salesContractPageButton);
		PageUtility.clickButton(driver, contractsAddContractButton);
		PageUtility.enterText(contractsTitle, null);
		PageUtility.enterText(contractsStartDate, null);
		PageUtility.enterText(contractsValidDate, null);
		PageUtility.clickButton(driver, contractClientDropdown);
		PageUtility.enterText(contractClientTextField, null);
		PageUtility.clickButton(driver, contractClientDropdown);
		PageUtility.clickButton(driver, contractClientTextField);
		PageUtility.clickButton(driver, contractProjectDropdown);
		PageUtility.clickButton(driver, contractProjectTextField);
		PageUtility.clickButton(driver, contractTaxDropdown);
		PageUtility.enterText(contractTaxTextField, null);
		PageUtility.clickButton(driver, contractSecondTaxDropdown);
		PageUtility.enterText(contractSecondTaxTextField, null);
		PageUtility.enterText(contractNote, null);
		
		PageUtility.clickButton(driver, contractSaveButton);
	}
	
	public void filteringContractsStatus(ArrayList<String> filterContract) {
		PageUtility.clickButton(driver, salesContractPageButton);
		PageUtility.clickButton(driver, contractsStatusFilterDropdown);
		PageUtility.enterText(contractsStatusFilterSelect, null);
	}
	
	public void downloadExcelContracts() {
		PageUtility.clickButton(driver, contractsExcelDownloadButton);
	}
	
	public void navigateContractForward() {
		PageUtility.clickButton(driver, contractsForwardNavigation);
	}
	
	public void navigateContractBackward() {
		PageUtility.clickButton(driver, contractsBackwardNavigation);
	}
	
	public void addItems(ArrayList<String> item) {
		PageUtility.clickButton(driver, itemsPageButton);
		PageUtility.enterText(itemsTitle, null);
		PageUtility.enterText(itemsDescription, null);
		PageUtility.clickButton(driver, itemsCategoryDropdown);
		PageUtility.enterText(itemsFilterCategoryTextField, null);
		PageUtility.enterText(itemsUntiType, null);
		PageUtility.enterText(itemsRate, null);
		PageUtility.clickButton(driver, itemsShowInPortal);
		
		PageUtility.clickButton(driver, itemsSaveButton);
	}
	
	public void filteringItemsCategory(ArrayList<String> filterItems) {
		PageUtility.clickButton(driver, itemsFilterCategoryDropdown);
		PageUtility.enterText(itemsFilterCategoryTextField, null);
	}
	
	public void storeAddToCart() {
		PageUtility.clickButton(driver, storePageButton);
		PageUtility.clickButton(driver, storeToCartButton);
	}
	
	public void storesPlaceOrder() {
		PageUtility.clickButton(driver, storesCartIconButton);
		PageUtility.clickButton(driver, storesProcessOrderButton);
		PageUtility.clickButton(driver, storesPlaceOrderButton);
	}

}
