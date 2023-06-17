package com.qedge.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ReadExcel  {
	/*name     : wbMethod
	written by : sai
	parameters : no
	return type: Workbook 
	description: method returns workbook by passing the file location */
	public static Workbook wbMethod(String filepath) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis=new FileInputStream(filepath);
		Workbook wb=WorkbookFactory.create(fis);
		return wb;
	}
	
	public static int lastRow(String SheetName) throws EncryptedDocumentException, InvalidFormatException, IOException {
		Workbook wb=wbMethod("C:\\Users\\QEdge\\workspace\\QEdge-8thBatch\\TestData.xlsx");
		Sheet s=wb.getSheet(SheetName);
		int lastrow=s.getLastRowNum();
		return lastrow;
	
	}
	public static String indCellStringValue(String SheetName, int Rown, int colN) throws EncryptedDocumentException, InvalidFormatException, IOException{
		Workbook wb=wbMethod("C:\\Users\\QEdge\\workspace\\QEdge-8thBatch\\TestData.xlsx");
		Sheet s=wb.getSheet(SheetName);
		Row r=s.getRow(Rown);
		Cell c=r.getCell(colN);
		String data=c.getStringCellValue();
		return data;
	}
	
	public static void allColumnStringValues(String SheetName, int colN) throws EncryptedDocumentException, InvalidFormatException, IOException {
		Workbook wb=wbMethod("C:\\Users\\QEdge\\workspace\\QEdge-8thBatch\\TestData.xlsx");
		Sheet s=wb.getSheet(SheetName);
		int lastrowN=lastRow(SheetName);
		for (int i = 1; i <=lastrowN; i++) {
			Row r=s.getRow(i);
			Cell c=r.getCell(colN);
			System.out.println(c.getStringCellValue());
		}
	}
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		allColumnStringValues("Students", 2);
	}
/*public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
	FileInputStream fis=new FileInputStream("C:\\Users\\QEdge\\workspace\\QEdge-8thBatch\\TestData.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	Sheet s=wb.getSheet("Students");
	Row r=s.getRow(1);
	Cell c=r.getCell(1);
	String data=c.getStringCellValue();
	Cell c2=r.getCell(0);
	double sno=c2.getNumericCellValue();
	System.out.println(sno);
	System.out.println(data);
	
}*/
}
