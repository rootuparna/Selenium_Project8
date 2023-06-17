package com.qedge.excel;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class WriteExcel extends ReadExcel{
public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
	Workbook wb=wbMethod("C:\\Users\\QEdge\\workspace\\QEdge-8thBatch\\TestData.xlsx");
	Sheet s=wb.createSheet("Sample");
	Row r=s.createRow(0);
	Cell c=r.createCell(0);
	c.setCellValue("Output");
	FileOutputStream fos=new FileOutputStream("C:\\Users\\QEdge\\workspace\\QEdge-8thBatch\\TestData.xlsx");
	wb.write(fos);
	fos.close();
	
	
}
}
