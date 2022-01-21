package com.buffaloCart.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffaloCart.utils.PageUtility;

public class ProjectsPage {
	
	WebDriver driver;
	
	public ProjectsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//a[@title='Add project']")
	WebElement addProjectButton;
	@FindBy(id ="title")
	WebElement projectTitle;
	@FindBy(xpath = "(//label[@for='client_id'])//parent::div//child::div//child::a")
	WebElement projectClientDropdown;
	@FindBy(id = "//div[@id='select2-drop']//child::input")
	WebElement projectClientTextField;
	@FindBy(id = "description")
	WebElement projectDescription;
	@FindBy(id = "start_date")
	WebElement projectStartDate;
	@FindBy(id = "deadline")
	WebElement projectDeadline;
	@FindBy(id = "price")
	WebElement projectPrice;
	@FindBy(id = "save-and-continue-button")
	WebElement projectSaveAndContinueButton;
	
	@FindBy(xpath = "(//label[@for='user_id'])//parent::div//child::div//child::a//child::span")
	WebElement projectMemberDropdown;
	@FindBy(xpath = "//div[@id='select2-drop']//child::input")
	WebElement projectMemberTextField;
	@FindBy(id = "next-button")
	WebElement projectNextButton;
	
	@FindBy(id ="title")
	WebElement projectTaskTitle;
	@FindBy(id = "description")
	WebElement projectTaskDescription;
	
	@FindBy(xpath = "(//*[contains (text(),'Points ')]//following-sibling::div//child::div)")
	WebElement projectTaskPointDropdown;
	@FindBy(xpath = "//div[@id='select2-drop']//child::input")
	WebElement projectTaskPointTextField;
	
	@FindBy(xpath = "(//*[contains (text(),'Milestone')]//following-sibling::div//child::div)")
	WebElement projectTaskMilestoneDropdown;
	@FindBy(xpath = "//div[@id='select2-drop']//child::input")
	WebElement projectTaskMilestoneTextField;
	
	@FindBy(xpath = "(//*[contains (text(),'Assign to')]//following-sibling::div//child::div)")
	WebElement projectTaskAssignDropdown;
	@FindBy(xpath = "//div[@id='select2-drop']//child::input")
	WebElement projectTaskAssignTextField;
	
	@FindBy(xpath = "//div[@id='s2id_collaborators']")
	WebElement projectTaskCollaborators;
	
	@FindBy(xpath = "(//label[@for='status_id'])//parent::div//child::div//child::a]")
	WebElement projectTaskStatusDropdown;
	@FindBy(xpath = "//div[@id='select2-drop']//child::input")
	WebElement projectTaskStatusTextField;
	
	@FindBy(id = "start_date")
	WebElement projectTaskStartDate;
	@FindBy(id = "deadline")
	WebElement projectTaskDeadline;
	@FindBy(id = "save-and-add-button")
	WebElement projectSaveAndAddButton;
	@FindBy(xpath = "(//*[contains (text(),' Close')])")
	WebElement projectCloseButton;
	
	@FindBy(xpath = "//button[@class='btn datepicker-custom-selector']")
	WebElement projectDateFilterDropdown;
	@FindBy(xpath = "(//div[@class='datepicker-custom-list list-group mb0']//child::div)[3]")
	WebElement projectDateFilterSelect;

	@FindBy(xpath = "//button[@class='btn btn-default dropdown-toggle caret']")
	WebElement projectStatusFilterDropdown;
	@FindBy(xpath = "(//ul[@class='list-group']//child::li)[2]")
	WebElement projectStatusFilterSelect;
	
	public void addProject(ArrayList<String> projects) {
		PageUtility.clickButton(driver, addProjectButton);
		PageUtility.enterText(projectTitle, null);
		PageUtility.clickButton(driver, projectClientDropdown);
		PageUtility.enterText(projectClientTextField, null);
		PageUtility.enterKey(projectClientTextField);
		PageUtility.enterText(projectStartDate, null);
		PageUtility.enterText(projectDeadline, null);
		PageUtility.enterText(projectPrice, null);
		PageUtility.clickButton(driver, projectSaveAndContinueButton);
		
		PageUtility.clickButton(driver, projectMemberDropdown);
		PageUtility.enterText(projectMemberTextField, null);
		PageUtility.clickButton(driver, projectNextButton);
		
		PageUtility.enterText(projectTaskTitle, null);
		PageUtility.enterText(projectTaskDescription, null);
		PageUtility.clickButton(driver, projectTaskPointDropdown);
		PageUtility.enterText(projectTaskPointTextField, null);
		PageUtility.clickButton(driver, projectTaskMilestoneDropdown);
		PageUtility.enterText(projectTaskMilestoneTextField, null);
		PageUtility.clickButton(driver, projectTaskAssignDropdown);
		PageUtility.enterText(projectTaskAssignTextField, null);
		PageUtility.enterText(projectTaskCollaborators, null);
		PageUtility.clickButton(driver, projectTaskStatusDropdown);
		PageUtility.enterText(projectTaskStatusTextField, null);
		PageUtility.enterText(projectTaskStartDate, null);
		PageUtility.enterText(projectTaskDeadline, null);
		PageUtility.clickButton(driver, projectSaveAndAddButton);
		
		PageUtility.clickButton(driver, projectCloseButton);
	}
	
	public void filteringProjectsDate() {
		PageUtility.clickButton(driver, projectDateFilterDropdown);
		PageUtility.clickButton(driver, projectDateFilterSelect);
	}
	
	public void filteringProjectsStatus() {
		PageUtility.clickButton(driver, projectStatusFilterDropdown);
		PageUtility.clickButton(driver, projectStatusFilterSelect);
	}
}

