package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class readdatafromexcel {

	public static void main(String[] args) throws Throwable {
		//set the path
	FileInputStream fes = new	FileInputStream("src/test/resources/yasu.xlsx");
	//open workbook in read mode
Workbook book = WorkbookFactory.create(fes);
//get the control to the sheet
Sheet sh = book.getSheet("Sheet1");
//get the control to the row
Row row = sh.getRow(1);
//get the control to the cell
Cell cel = row.getCell(1);
//fetch the data from cell
String data1 = cel.getStringCellValue();
System.out.println(data1);
		
		// TODO Auto-generated method stub

	}

}
