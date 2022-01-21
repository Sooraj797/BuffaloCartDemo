package com.buffaloCart.testCases;

import java.io.IOException;
import java.util.ArrayList;

import com.buffaloCart.base.BaseSetUp;
import com.buffaloCart.pages.LoginPage;
import com.buffaloCart.pages.ProjectsPage;
import com.buffaloCart.utils.DataRead;

public class ProjectsTestCase extends BaseSetUp {
	
	DataRead dataRead = new DataRead(driver);
	LoginPage loginPage;
	ProjectsPage projectsPage = new ProjectsPage(driver);
	
	String eg1;
	
	ArrayList<String> projects = new ArrayList<String>();
	
	public void addProjectTestCase(String browser) throws IOException {
		for (int i = 1; i <= 16; i++) {
			eg1 = dataRead.readStringData(1, i, "AddProject");
			projects.add(eg1);
		}
		projectsPage.addProject(projects);
	}
	
	public void filteringProjectsDateTestCase(String browser) {
		projectsPage.filteringProjectsDate();
	}
	
	public void filteringProjectsStatusTestCase(String browser) {
		projectsPage.filteringProjectsStatus();
	}

}
