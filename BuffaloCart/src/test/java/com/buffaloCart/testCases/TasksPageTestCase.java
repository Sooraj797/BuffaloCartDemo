package com.buffaloCart.testCases;

import java.io.IOException;
import java.util.ArrayList;

import com.buffaloCart.base.BaseSetUp;
import com.buffaloCart.pages.LoginPage;
import com.buffaloCart.pages.TasksPage;
import com.buffaloCart.utils.DataRead;

public class TasksPageTestCase extends BaseSetUp {
	
	DataRead dataRead = new DataRead(driver);
	LoginPage loginPage;
	TasksPage tasksPage = new TasksPage(driver);
	
	String eg1;
	
	ArrayList<String> tasks = new ArrayList<String>();
	
	public void addTasksTestCase(String browser) throws IOException {
		for (int i = 1; i <= 16; i++) {
			eg1 = dataRead.readStringData(1, i, "AddTask");
			tasks.add(eg1);
		}
		tasksPage.addTasks(tasks);
	}
	
	public void filteringTasksDateTestCase(String browser) {
		tasksPage.filteringTasksDate();
	}
	
	public void filteringTasksStatusTestCase(String browser) {
		tasksPage.filteringTasksStatus();
	}

}
