package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingSingleFromExcelFile {

	public static void main(String[] args) throws Throwable {

		//step1:- path connection
FileInputStream fis = new FileInputStream("./src/test/resources/TestSheet.xlsx");

       //step2:- excel file in read mode
	Workbook book = WorkbookFactory.create(fis);
	  
	//step3:- get control on sheet
	Sheet sheet = book.getSheet("Sheet1");
	
	//step4:- get control on row
	Row row = sheet.getRow(0);
	
	//step5:- get control on cell
	Cell cell = row.getCell(0);
	
	//step6:-fetching the cell value
//	String excelData = cell.getStringCellValue();
//	double excelData = cell.getNumericCellValue();
	
	//DataFormatter
	DataFormatter format = new DataFormatter();
	String excelData = format.formatCellValue(cell);
	System.out.println(excelData);
	}
}