package generic_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {

	public String getExcelData(String sheetName, int rowNum, int cellNum) throws Throwable {
		// step1:- path connection

		FileInputStream fis1 = new FileInputStream(IPathConstants.ExcelPath);

		// step2:- excel file in read mode
		Workbook book = WorkbookFactory.create(fis1);

		// step3:- get control on sheet
		Sheet sheet = book.getSheet(sheetName);

		// step4:- get control on row
		Row row = sheet.getRow(rowNum);

		// step5:- get control on cell
		Cell cell = row.getCell(cellNum);

		// step6:-fetching the cell value
		String ExcelData = cell.getStringCellValue();
		return ExcelData;

	}

	public String getExcelDataUsingDataFormatter(String sheetName, int rowNum, int cellNum) throws Throwable {

		FileInputStream fis2 = new FileInputStream(IPathConstants.ExcelPath);

		// step2:- excel file in read mode
		Workbook book = WorkbookFactory.create(fis2);

		// step3:- get control on sheet
		Sheet sheet = book.getSheet(sheetName);
		Row row1 = sheet.getRow(rowNum);

		// step5:- get control on cell
		Cell cell1 = row1.getCell(cellNum);

		// step6:-fetching the cell value
		DataFormatter format = new DataFormatter();

		String excelData = format.formatCellValue(cell1);

		return excelData;
	}

	public Object[][] getDataProviderData(String sheetName) throws Throwable
	{
		
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum()+1;
		int lastCell = sheet.getRow(0).getLastCellNum();
		
		Object[][] objArr = new Object[lastRow][lastCell];
		
		for (int i = 0; i <lastRow ; i++)
		{
		for (int j = 0; j <lastCell ; j++)
		{
			objArr[i][j]=sheet.getRow(i).getCell(j).toString();
		}	
		}
		
		return objArr;
		
	}
}