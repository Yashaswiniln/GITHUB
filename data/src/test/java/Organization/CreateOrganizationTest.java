package Organization;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.Excel_Utility;
import GenericUtility.File_Utility;
import GenericUtility.Java_Utility;
import OrganizationPom.HomePage;
import OrganizationPom.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTest  extends BaseClass{
//@Test(retryAnalyzer =GenericUtility.RetryAnalyser.class)
@Test
	//@Test(groups="smokeTest")
	public  void createOrganizationTest() throws Throwable {
	WebDriverManager.chromedriver().setup();

		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
driver.findElement(By.name("user_name")).sendKeys("admin");

driver.findElement(By.name("user_password")).sendKeys("admin");
driver.findElement(By.id("submitButton")).click();
/*File_Utility flib=new File_Utility();

String URL = flib.getStringKeyAndValue("url");
String USERNAME = flib.getStringKeyAndValue("username");
String PASSWORD = flib.getStringKeyAndValue("password");
driver.get(URL);
//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//driver.findElement(By.id("submitButton")).click();*/
//CALLING POM
//LoginPage login = new LoginPage(driver);
//login.loginToApp(USERNAME, PASSWORD);
//login.getLoginButton().click();
//home page
//HomePage home = new HomePage(driver);
//home.organizationLink();
//driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);
//driver.findElement(By.linkText("Organizations")).click();
driver.findElement(By.xpath("//a[text()='Organizations']")).click();
driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
Java_Utility jlib=new Java_Utility();
int ranNum = jlib.getRandomNum();
Excel_Utility elib=new Excel_Utility();
String orgName = elib.getExcelData("Organization", 0, 0)+ranNum;
AssertJUnit.assertEquals(false, true);
//String orgName = elib.getExcelDataUsingDataFormatter("Organization", 0, 0)+ranNum;
driver.findElement(By.name("accountname")).sendKeys(orgName);
//Excel_Utility elib=new Excel_Utility();
String phoneNum = elib.getExcelDataUsingDataFormatter("Organization", 1, 0);
	driver.findElement(By.id("phone")).sendKeys(phoneNum);
String email = elib.getExcelDataUsingDataFormatter("Organization", 2, 0);
driver.findElement(By.id("email1")).sendKeys(email);
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
}

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	





















