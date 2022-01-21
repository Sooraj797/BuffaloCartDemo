package com.buffaloCart.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;

public class DateUtility {
	
	WebDriver driver;
	
	public DateUtility(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getDate() {
		SimpleDateFormat timeStamp = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = timeStamp.format(Calendar.getInstance().getTime());
		System.out.println(currentDate);
		return currentDate;
	}
	

}

