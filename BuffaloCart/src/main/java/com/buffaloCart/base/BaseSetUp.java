package com.buffaloCart.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.buffaloCart.constants.Constants;
import com.buffaloCart.utils.Log;

public class BaseSetUp {
	
	public static WebDriver driver;
	public static Properties property;
	public Log log;
	
	@Parameters({"browser"})
	@BeforeTest
	public void setUpBrowser(String browser) throws IOException {
		
		property = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+Constants.CONFIGfILE);
		property.load(ip);
	   
		if(browser.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", property.getProperty("chromeFilePath"));
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
		}else if(browser.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", property.getProperty("firefoxFilePath"));
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			
		}else {
			Log.warn("Browser not listed");
		}
		
		driver.get(property.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
	}

}
