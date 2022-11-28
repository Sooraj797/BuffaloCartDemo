package com.buffaloCartCRM.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffaloCartCRM.constants.Constants;
import com.buffaloCartCRM.utils.PageUtility;
import com.buffaloCartCRM.utils.WaitUtility;

public class TasksPage {
	
	WebDriver driver;
	
	public TasksPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver;
		
	}
	
	@FindBy(xpath = "//span[text()='Dashboard']")
	WebElement goToDashboardPage;
	
	@FindBy(xpath = "//span[text()='Tasks']")
	WebElement goToTasksPage;
	@FindBy(xpath = "//a[@title='Add task']")
	WebElement addTasksButton;
	
	@FindBy(id = "title")
	WebElement tasksTitle;
	@FindBy(id = "description")
	WebElement tasksDescription;
	
	@FindBy(xpath = "//*[contains (text(),'Project')]//following-sibling::div//child::div//child::a")
	WebElement tasksProjectDropdown;
	@FindBy(xpath = "(//*[contains (text(),'Project')]//following-sibling::input)[2]")
	WebElement tasksProjectTextField;
	
	@FindBy(xpath = "(//div[@id='link-of-new-view']//parent::div//child::div//following-sibling::button)[1]")
	WebElement tasksFileUploadButton;
	
	@FindBy(xpath = "//button[@id='save-and-show-button']//following-sibling::button")
	WebElement tasksSaveButton;
	@FindBy(xpath = "(//*[contains (text(),' Close')])")
	WebElement tasksCloseButton;
	
	@FindBy(xpath="//*[contains(text(), 'MainTask')]")
	WebElement tasksMainTitle;
	
	@FindBy(xpath = "//button[@class='btn datepicker-custom-selector']")
	WebElement tasksDateFilterDropdown;
	@FindBy(xpath = "(//div[@class='datepicker-custom-list list-group mb0']//child::div)[3]")
	WebElement tasksDateFilterSelect;
	
	@FindBy(xpath = "//span[@class='dropdown inline-block filter-multi-select']//parent::button")
	WebElement tasksStatusFilterDropdown;
	@FindBy(xpath = "(//ul[@class='list-group']//child::li)[1]")
	WebElement tasksStatusFilterSelect;
	
	public boolean addTasks(String title, String description, String project) throws IOException, InterruptedException {
		
		PageUtility.clickButton(driver, goToTasksPage);
		
		PageUtility.clickButton(driver, addTasksButton);
		
		PageUtility.enterText(tasksTitle, title);
		PageUtility.enterText(tasksDescription, description);
		
		WaitUtility.waitExplicitToBevisibilityOfAllElements(tasksProjectDropdown);
		PageUtility.clickActionButton(driver, tasksProjectDropdown);
		PageUtility.enterText(tasksProjectTextField, project);
		PageUtility.enterKey(tasksProjectTextField);
		
		WaitUtility.waitExplicitToBeClickable(tasksFileUploadButton);
		PageUtility.clickButton(driver, tasksFileUploadButton);
		Runtime.getRuntime().exec(Constants.FileUpload);
		Thread.sleep(12000);
		
		WaitUtility.waitExplicitToBeClickable(tasksSaveButton);
		PageUtility.clickActionButton(driver, tasksSaveButton);
		Thread.sleep(6000);
		
		Boolean verify = PageUtility.displayed(tasksMainTitle);
		WaitUtility.waitImplicit(5);
		
		return verify;
		
	}
	
	public boolean filteringTasksDate() {
		
		PageUtility.clickButton(driver, tasksDateFilterDropdown);
		PageUtility.clickButton(driver, tasksDateFilterSelect);
		
		WaitUtility.waitImplicit(5);
		boolean verify = PageUtility.enabled(tasksDateFilterSelect);
		System.out.println(verify);
		return verify;
	}
	
	public boolean filteringTasksStatus() {
		
		PageUtility.clickButton(driver, tasksStatusFilterDropdown);
		PageUtility.clickButton(driver, tasksStatusFilterSelect);
		
		WaitUtility.waitImplicit(5);
		boolean verify = PageUtility.enabled(tasksStatusFilterSelect);
		System.out.println(verify);
		return verify;
		
	}
	
	public void returnToDashBoard() {
		
		PageUtility.clickButton(driver, goToDashboardPage);
		
	}

}
