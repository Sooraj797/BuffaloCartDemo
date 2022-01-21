package com.buffaloCart.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;

import com.buffaloCart.base.BaseSetUp;
import com.buffaloCart.constants.Constants;

public class DataRead extends BaseSetUp {
	
	  public DataRead(WebDriver driver) {
		  this.driver=driver;
	  }
	 
	
	Constants constants;
	
	public static FileInputStream file;
	public static HSSFWorkbook workbook;
	public static HSSFSheet sheet;
	
	public String readStringData(int r, int c, String sheetName) throws IOException {
		
		file = new FileInputStream("D:\\Selenium Training\\Selenium WebDriver Projects\\BuffaloCart\\test.xls");
		workbook = new HSSFWorkbook(file);
		sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(r);
		Cell col = row.getCell(c);
		DataFormatter formatter = new DataFormatter();
		String strValue = formatter.formatCellValue(col);
		
		return strValue;
		
	}
	
	public int getLastColumn(int r, String sheetName) throws IOException {
		
		file = new FileInputStream("./test.xls");
		workbook = new HSSFWorkbook(file);
		sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(r);
		int c=row.getLastCellNum();
	
		return c;
		
	}
	
	/*
	 * public String readIntegerData(int r, int c, String sheetName) throws
	 * IOException {
	 * 
	 * file = new FileInputStream(constants.EXCELFILE); workbook = new
	 * HSSFWorkbook(file); sheet = workbook.getSheet(sheetName); Row row =
	 * sheet.getRow(r); Cell col = row.getCell(c); long val = (long)
	 * col.getNumericCellValue();
	 * 
	 * return String.valueOf(val);
	 * 
	 * }
	 */

}
