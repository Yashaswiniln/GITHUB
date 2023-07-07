package Organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.Excel_Utility;
import GenericUtility.File_Utility;
import GenericUtility.Java_Utility;
import GenericUtility.WebDriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
@Test(groups= {"smokeTest","regressionTest"})

public class CreateProductWithDeleteProductTest extends BaseClass {

	public void createCOMPAIGN1Test()throws Throwable {
		// TODO Auto-generated method stub
		//WebDriverManager.chromedriver().setup();
	//	WebDriver driver=new ChromeDriver();
		File_Utility flib=new File_Utility();
		String BROWSER = flib.getStringKeyAndValue("browser");
		WebDriver driver;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			}
		else
		{
			driver=new ChromeDriver();
		}
	String URL = flib.getStringKeyAndValue("url");
	String USERNAME = flib.getStringKeyAndValue("username");
	String PASSWORD = flib.getStringKeyAndValue("password");
		/*driver.get("http://localhost:8888/");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);*/
	driver.get(URL);
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	WebDriver_Utility wlib = new WebDriver_Utility();
	wlib.maximizeScreen(driver);
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
	Java_Utility jlib=new Java_Utility();
	 int ranNum = jlib.getRandomNum();
		// Random ran = new Random();
		// int ranNum = ran.nextInt(1000);
		Excel_Utility elib=new Excel_Utility();
	 String orgName = elib.getExcelData("Organization", 0, 0)+ranNum;
driver.findElement(By.name("productname")).sendKeys("orgName");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//producttable
	driver.findElement(By.xpath("//a[text()='Products")).click();
	
		//driver.findElement(By.xpath("//table[@class='lvt small']/tbody//td//a[text()='"+proddata+"']/../precedding-sibling::td/input")).click();
		//driver.findElement(By.xpath("//input[@value='Delete")).click();
	
		driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")).click();
		


	//	WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.Alertaccept(driver);
		// Alert alt = driver.switchTo().alert();
		// alt.accept();
		//driver.findElements(By.xpath("("));
		

	}

}
