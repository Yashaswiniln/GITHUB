package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class writemultipledatatoexcel {

	public static void main(String[] args) throws Throwable {
		//set the path
	FileInputStream fes = new	FileInputStream("src/test/resources/yashu.xlsx");
	//open workbook in read mode
Workbook book = WorkbookFactory.create(fes);
//get the control to the sheet
Sheet sh = book.getSheet("Sheet1");
//get the control to the row
WebDriverManager.chromedriver().setup();

	WebDriver driver=new ChromeDriver();
	driver.get("https://www.amazon.in/");
	List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
	for(int i=0;i<allLinks.size();i++)
	{
	Row row = sh.createRow(i);
	Cell cel = row.createCell(0);
	cel.setCellValue(allLinks.get(i).getAttribute("href"));
	
	}
	FileOutputStream fos = new FileOutputStream("src/test/resources/yashu.xlsx");
	book.write(fos);
	book.close();
	
	}

}
