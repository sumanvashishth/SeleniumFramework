package com.banking.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFRow row;
	public static XSSFSheet sheet;
	public static XSSFCell cell;
	public static String data;
	
	public static int getrowcount(String xlfile, String xlsheet) throws IOException{
		
		fi= new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		sheet=wb.getSheet(xlsheet);
		int rowcount = sheet.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
	}
	
	public static int getcelllcount(String xlfile, String xlsheet , int rownum) throws IOException{
		
		fi= new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		sheet=wb.getSheet(xlsheet);
		row = sheet.getRow(rownum);
		int cellcount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}
	
	public static String getCellData(String xlfile , String xlsheet , int rownum, int colnum) throws IOException{
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(xlsheet);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		try{
			DataFormatter df = new DataFormatter();
			String celldata = df.formatCellValue(cell);
			return celldata;
			
		}
		catch (Exception e) {
			// TODO: handle exception
			data = "";
		}
		wb.close();
		fi.close();
		return data;
	}
	
	public static void setCellData(String xlfile , String xlsheet , int rownum, int colnum) throws IOException{
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(xlsheet);
		row = sheet.getRow(rownum);
		cell = row.createCell(colnum);
		cell.setCellValue(data);
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();

	}
	
}
