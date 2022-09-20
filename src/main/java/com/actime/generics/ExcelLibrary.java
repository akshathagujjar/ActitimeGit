package com.actime.generics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLibrary implements AutoConstants
{
	public static String getCellValue(String sheet, int row, int cell) throws IOException
	{
		FileInputStream f = new FileInputStream(excel_path);
		XSSFWorkbook wb = new XSSFWorkbook(f);
		String cell_Value = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return cell_Value;
	}
}
