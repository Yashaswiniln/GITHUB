package Properties;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import GenericUtility.Excel_Utility;
import GenericUtility.File_Utility;
import GenericUtility.Java_Utility;
import GenericUtility.WebDriver_Utility;
import OrganizationPom.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CREATE_ORGANIZATION {

	public static void main(String[] args) throws Throwable {
	WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
	WebDriver_Utility wlib = new	WebDriver_Utility();
	wlib.maximizeScreen(driver);
	//wlib.minimizeScreen(driver);
		File_Utility flib=new File_Utility();
/*	String BROWSER = flib.getStringKeyAndValue("browser");
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
	}*/
	
	String URL = flib.getStringKeyAndValue("url");
	String USERNAME = flib.getStringKeyAndValue("username");
	String PASSWORD = flib.getStringKeyAndValue("password");
	driver.get(URL);
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	wlib.switchToWindow(driver, "Products");
driver.findElement(By.id("submitButton")).click();
//CALLING POM
 LoginPage login = new LoginPage(driver);
 login.loginToApp(USERNAME, PASSWORD);
 login.getLoginButton().click();

driver.findElement(By.linkText("Organizations")).click();
driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
Java_Utility jlib = new Java_Utility();
int ranNumb = jlib.getRandomNum();
//Random r=new Random();
//int ranNum = r.nextInt(1000);
 Excel_Utility elib = new Excel_Utility();
 //String orgName = elib.getExcelData("Organization", 0, 0)+ranNum;
String orgName = elib.getExcelData("Organization", 0, 0)+ranNumb;
driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
String phoneNum = elib.getExcelDataUsingDataFormatter("Organization", 1, 0);
driver.findElement(By.id("phone")).sendKeys(phoneNum);
String EMAIL = elib.getExcelDataUsingDataFormatter("Organization", 3, 0);

driver.findElement(By.id("email1")).sendKeys(EMAIL);
driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();

driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}
}

//Thread.sleep(1000);
// WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
 
 //Actions act=new Actions(driver);
 //act.moveToElement(ele).perform();
 
 
//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	
	

	


