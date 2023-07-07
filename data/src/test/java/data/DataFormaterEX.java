package data;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataFormaterEX {

	

		public static void main(String[] args) throws Throwable {
			//set the path
			FileInputStream fis = new	FileInputStream("src/test/resources/number.xlsx");
			//open workbook in read mode
		Workbook book = WorkbookFactory.create(fis);
		//get the control to the sheet
		Sheet sh = book.getSheet("Sheet1");
       //get the control to the row
		Row row = sh.getRow(0);
	Cell cel = row.getCell(0);
	 DataFormatter format = new DataFormatter();
	String data = format.formatCellValue(cel);
	System.out.println(data);
	


	}

}
