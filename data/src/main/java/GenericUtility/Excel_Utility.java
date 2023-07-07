package GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
public String getExcelData(String sheetName,int rowNum,int cellNum) throws Throwable
{
	/**
	 * THIS METHOD IS USED TO FETCH THE DATA FROM EXCEL
	 */
	   FileInputStream fis = new	FileInputStream("src/test/resources/VTIGEREXCEL2.xlsx");
	   Workbook book = WorkbookFactory.create(fis);
	   Sheet sh = book.getSheet(sheetName);
	   Row row = sh.getRow(rowNum);
	       Cell cel = row.getCell(cellNum);
	     String value = cel.getStringCellValue();
	     return value;
	    
	   	}
	public String getExcelDataUsingDataFormatter(String SheetName,int rowNum,int cellNum) throws Throwable
	{
		 FileInputStream fis1 = new	FileInputStream("src/test/resources/VTIGEREXCEL2.xlsx");
		   Workbook book=WorkbookFactory.create(fis1);
	DataFormatter format = new DataFormatter();
   String value = format.formatCellValue(book.getSheet(SheetName).getRow(rowNum).getCell(cellNum));
		return value;
	}
	
	
	
	
	

}
