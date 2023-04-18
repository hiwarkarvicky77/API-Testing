package com.pom;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldataprovider {
	
XSSFWorkbook wb;
	
	public Exceldataprovider () throws Exception  {
		
		String Path = "/Users/vicky/eclipse-workspace/API_Testing/Testdata/RestData.xlsx" ;
		
		FileInputStream fis = new FileInputStream(Path);
		 
		    wb = new XSSFWorkbook(fis);	}
	
	public String getstringdata (String sheetname , int row , int cell) {
		return  wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		
	}

	public double getintdata (String sheetname , int row , int cell) {
		return  wb.getSheet(sheetname).getRow(row).getCell(cell).getNumericCellValue();
	}

}
