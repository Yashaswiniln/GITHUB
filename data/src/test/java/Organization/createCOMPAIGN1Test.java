package Organization;

import java.util.Random;

import org.openqa.selenium.By;
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
import OrganizationPom.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
@Test(groups="regressionTest")
public class createCOMPAIGN1Test extends BaseClass{

	public  void createCOMPAIGN1Test() throws Throwable {
	
			WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
		/*WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.maximizeScreen(driver);
				File_Utility flib=new File_Utility();
				
				String URL = flib.getStringKeyAndValue("url");
				String USERNAME = flib.getStringKeyAndValue("username");
				String PASSWORD = flib.getStringKeyAndValue("password");
				driver.get(URL);
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();*/
			
			
				driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");

		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

//	HomePage home = new HomePage(driver);
		//	home.ProductsLink();


		driver.findElement(By.xpath("//a[text()='Products']")).click();
		
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		Java_Utility jlib = new Java_Utility();
		int ranNumb = jlib.getRandomNum();

	//	Random r=new Random();
	//int data = r.nextInt(1000);
		Excel_Utility elib = new Excel_Utility();
	String prdname = elib.getExcelDataUsingDataFormatter("camp", 1, 0);
	 driver.findElement(By.name("productname")).sendKeys(prdname);
			
		driver.findElement(By.linkText("More")).click();
//driver.findElement(By.xpath("//img[@src='themes/images/arrow_down_black.png']")).click();
driver.findElement(By.linkText("Campaigns"))	.click();
driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();

String campname = elib.getExcelDataUsingDataFormatter("camp", 0, 0);
driver.findElement(By.name("campaignname")).sendKeys(campname);
driver.findElement(By.xpath("//img[@alt='Select']")).click();
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
String actdata = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
{
	if(actdata.contains(campname))
	{
		System.out.println("script pass");
	}
	else
	{
		System.out.println("script fail");
	}
}
WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//wlib.mouseOverElement(driver, ele);
Thread.sleep(1000);
driver.findElement(By.xpath("//a[text()='Sign Out']")).click();


}
}