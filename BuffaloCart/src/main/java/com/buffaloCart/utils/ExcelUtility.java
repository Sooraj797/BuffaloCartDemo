package com.buffaloCart.utils;

import java.io.IOException;
import java.util.ArrayList;

import com.buffaloCart.base.BaseSetUp;

public class ExcelUtility extends BaseSetUp {
	
	DataRead dataRead = new DataRead(driver);
	ArrayList<String> data;
	
	public ArrayList<String> readExcel(int r, String sheetName) throws IOException{
		data = new ArrayList<String>();
		
		int column = dataRead.getLastColumn(r, sheetName);
		
		for(int i=0; i<=column; i++) {
			data.add(dataRead.readStringData(r, i, sheetName));
		}
		
		return data;
	}

}
