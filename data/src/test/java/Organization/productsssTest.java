package Organization;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import GenericUtility.Excel_Utility;
import GenericUtility.File_Utility;
import GenericUtility.Java_Utility;
import GenericUtility.WebDriver_Utility;
import OrganizationPom.HomePage;
import OrganizationPom.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
@Test(groups="smokeTest")
public class productsssTest {

	public void productsssTest() throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
	WebDriver_Utility wlib = new WebDriver_Utility();
	wlib.maximizeScreen(driver);
	File_Utility flib = new File_Utility();
 String URL = flib.getStringKeyAndValue("url");
String USERNAME = flib.getStringKeyAndValue("username");
String PASSWORD = flib.getStringKeyAndValue("password");
driver.get(URL);
LoginPage login = new LoginPage(driver);
login.loginToApp(USERNAME, PASSWORD);
login.getLoginButton().click();
Thread.sleep(3000);
//home page
//HomePage home = new HomePage(driver);
//home.ProductsLink();



		//driver.get("http://localhost:8888/");
		//driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME,Keys.TAB,PASSWORD,Keys.ENTER);
driver.findElement(By.xpath("//a[text()='Products']")).click();

		//driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
	Java_Utility jlib = new	Java_Utility();
	int ranNum = jlib.getRandomNum();
	Excel_Utility elib = new Excel_Utility();
String prd = elib.getExcelDataUsingDataFormatter("prod", 0, 0);
		driver.findElement(By.name("productname")).sendKeys(prd+ranNum);
 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
Thread.sleep(1000);
	WebElement saveButton = driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]"));
//	JavascriptExecutor js = (JavascriptExecutor)driver;
wlib.javaScriptExecutor(driver, saveButton);
	saveButton.click();
	

//js.executeScript("arguments[0].scrollIntoView",saveButton);
	
	/*	Rectangle value = data.getRect();
		System.out.println(value.getHeight());
		System.out.println(value.getWidth());
		System.out.println(value.getX());
		System.out.println(value.getY());
		JavaScriptExecutor js = (JavaScriptExecutor)driver;
		for(int i=0;i<5;i++)
		{
			js.executeScript("window.scrollBy(0,229)");
			Thread.sleep(1000);
			
		}
	 driver.findElement(By.xpath("//input[@title='Save [Alt+S]'])[2]")).click();*/

	}

}

