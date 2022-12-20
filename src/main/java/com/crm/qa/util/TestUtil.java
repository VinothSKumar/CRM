package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public static long 	PAGE_LOAD_TIMEOUT = 100;
	public static long IMPLICIT_WAIT=10;
	public static String TEST_DATASHEET_PATH;
	public static Workbook book;
	public static Sheet sheet;
	
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
	
	public Object[][] getTestData(String sheetName) {
		FileInputStream inputstream=null;
		try {
			inputstream=new FileInputStream(TEST_DATASHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
		 book=new XSSFWorkbook(inputstream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
}
