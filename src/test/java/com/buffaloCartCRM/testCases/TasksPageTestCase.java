package com.buffaloCartCRM.testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.buffaloCartCRM.base.BaseSetUp;
import com.buffaloCartCRM.constants.Constants;
import com.buffaloCartCRM.pages.TasksPage;
import com.buffaloCartCRM.utils.ExcelRead;

public class TasksPageTestCase extends BaseSetUp {
	
	TasksPage tasksPage;
	
	@Test(testName = "AddTaskTestCase", dataProvider="AddTaskDetails", priority = 13)
	public void addTasksTestCase(String title, String description, String project) throws IOException, InterruptedException {
		
		tasksPage = new TasksPage(driver);
		
		boolean check = tasksPage.addTasks(title, description, project);
		
		SoftAssert addTask = new SoftAssert();
		addTask.assertTrue(check, "Added Task Successfully");
		addTask.assertAll();
		
	}
	
	@Test(testName = "FilteringTasksDateTestCase", priority = 14)
	public void filteringTasksDateTestCase() {
		
		boolean check = tasksPage.filteringTasksDate();
		
		SoftAssert checkFilter = new SoftAssert();
		checkFilter.assertTrue(check, "Tasks Filtered according to date");
		checkFilter.assertAll();
	}
	
	@Test(testName = "FilteringTasksStatusTestCase", priority = 15)
	public void filteringTasksStatusTestCase() {
		
		boolean check = tasksPage.filteringTasksStatus();
		
		SoftAssert checkFilter = new SoftAssert();
		checkFilter.assertTrue(check, "Tasks Filtered according to status");
		checkFilter.assertAll();
		
		tasksPage.returnToDashBoard();
		
	}
	
	@DataProvider(name ="AddTaskDetails")
	public Object[][] AddTaskDetails() throws IOException, EncryptedDocumentException, InvalidFormatException{
		
		Object[][] data = ExcelRead.getDataFromExcel(Constants.TaskCases, "AddTask");
		return data;
		
	}

}
