package com.buffaloCartCRM.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.buffaloCartCRM.constants.Constants;
import com.buffaloCartCRM.utils.WaitUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseSetUp {
	
	public static WebDriver driver;
	public static Properties property;
	
	
	
	@Parameters({"browser"})
	@BeforeTest(alwaysRun = true)
	public void setUpBrowser(String browser) throws IOException {
		
		//TO LOAD THE PATH OF CONFIG FILE IN THIS CLASS(LINE 20 TO 22)
		property = new Properties();
		FileInputStream input = new FileInputStream(System.getProperty("user.dir")+Constants.CONFIGfILE);
		property.load(input);
		
		//IF-ELSE CONDITION TO SELECT THE BROWSER DRIVER
		if(browser.equalsIgnoreCase(Constants.CHROMEBROWSER)) {
			
			WebDriverManager.chromedriver().setup();
			//System.setProperty(Constants.CHROMEDRIVER, property.getProperty("chromeFilePath"));
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
		}else if(browser.equalsIgnoreCase(Constants.FIREFOXBROWSER)) {
			
			WebDriverManager.firefoxdriver().setup();
			//System.getProperty(Constants.FIREFOXDRIVER, property.getProperty("firefoxFilePath"));
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			
		}else if(browser.equalsIgnoreCase(Constants.EDGEBROWSER)) {
			
			WebDriverManager.edgedriver().setup();
			//System.getProperty(Constants.EDGEDRIVER, property.getProperty("edgeFilePath"));
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			
		}else {
			System.out.println("No valid browser driver available");
		}
		
		driver.get(property.getProperty("url"));
		WaitUtility.waitImplicit(4);
		
	}
	
	/*
	 * @BeforeClass(alwaysRun = true) public void websiteSetUp() {
	 * 
	 * driver.get(property.getProperty("url")); WaitUtility.waitImplicit(4);
	 * 
	 * }
	 */

}
