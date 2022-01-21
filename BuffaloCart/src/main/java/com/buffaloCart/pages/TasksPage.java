package com.buffaloCart.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffaloCart.utils.PageUtility;

public class TasksPage {
	
	WebDriver driver;
	
	public TasksPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//*[contains (text(),'Tasks')]//parent::a")
	WebElement tasksPageButton;
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
	
	@FindBy(xpath = "(//*[contains (text(),'Points ')]//following-sibling::div//child::div)")
	WebElement tasksPointDropdown;
	@FindBy(xpath = "//div[@id='select2-drop']//child::input")
	WebElement tasksPointTextField;
	
	@FindBy(xpath = "(//*[contains (text(),'Milestone')]//following-sibling::div//child::div//child::a)")
	WebElement tasksMilestoneDropdown;
	@FindBy(xpath = "//div[@id='select2-drop']//child::input")
	WebElement tasksMilestoneTextField;
	
	@FindBy(xpath = "(//*[contains (text(),'Assign to')]//following-sibling::div//child::div)")
	WebElement tasksAssignDropdown;
	@FindBy(xpath = "//div[@id='select2-drop']//child::input")
	WebElement tasksAssignTextField;
	
	@FindBy(xpath = "//div[@id='s2id_collaborators']")
	WebElement tasksCollaborators;
	
	@FindBy(xpath = "(//label[@for='status_id'])//parent::div//child::div//child::a]")
	WebElement tasksStatusDropdown;
	@FindBy(xpath = "//div[@id='select2-drop']//child::input")
	WebElement tasksStatusTextField;
	
	@FindBy(id = "start_date")
	WebElement tasksStartDate;
	@FindBy(id = "deadline")
	WebElement tasksDeadline;
	@FindBy(id = "save-and-show-button")
	WebElement projectSaveAndShowButton;
	@FindBy(xpath = "(//*[contains (text(),' Close')])")
	WebElement tasksCloseButton;
	
	@FindBy(xpath = "//button[@class='btn datepicker-custom-selector']")
	WebElement tasksDateFilterDropdown;
	@FindBy(xpath = "(//div[@class='datepicker-custom-list list-group mb0']//child::div)[3]")
	WebElement tasksDateFilterSelect;
	
	@FindBy(xpath = "//button[@class='btn btn-default dropdown-toggle caret']")
	WebElement tasksStatusFilterDropdown;
	@FindBy(xpath = "(//ul[@class='list-group']//child::li)[2]")
	WebElement tasksStatusFilterSelect;
	
	public void addTasks(ArrayList<String> project) {
		PageUtility.clickButton(driver, tasksPageButton);
		PageUtility.clickButton(driver, addTasksButton);
		PageUtility.enterText(tasksTitle, null);
		PageUtility.enterText(tasksDescription, null);
		PageUtility.clickButton(driver, tasksProjectDropdown);
		PageUtility.enterText(tasksProjectTextField, null);
		PageUtility.clickButton(driver, tasksPointDropdown);
		PageUtility.enterText(tasksProjectTextField, null);
		PageUtility.clickButton(driver, tasksMilestoneDropdown);
		PageUtility.enterText(tasksMilestoneTextField, null);
		PageUtility.clickButton(driver, tasksAssignDropdown);
		PageUtility.enterText(tasksAssignTextField, null);
		PageUtility.enterText(tasksCollaborators, null);
		PageUtility.clickButton(driver, tasksStatusFilterDropdown);
		PageUtility.enterText(tasksStatusTextField, null);
		PageUtility.enterText(tasksStartDate, null);
		PageUtility.enterText(tasksDeadline, null);
		PageUtility.clickButton(driver, projectSaveAndShowButton);
		
		PageUtility.clickButton(driver, tasksCloseButton);
	}
	
	public void filteringTasksDate() {
		PageUtility.clickButton(driver, tasksDateFilterDropdown);
		PageUtility.clickButton(driver, tasksDateFilterSelect);
	}
	
	public void filteringTasksStatus() {
		PageUtility.clickButton(driver, tasksStatusFilterDropdown);
		PageUtility.clickButton(driver, tasksStatusFilterSelect);
	}

}
