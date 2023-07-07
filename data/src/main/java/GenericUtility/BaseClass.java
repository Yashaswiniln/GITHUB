package GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import OrganizationPom.HomePage;
import OrganizationPom.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
		public WebDriver driver;
		public static WebDriver sdriver;
		@BeforeSuite
	public void beforeSuite()
	{
			System.out.println("DataBase Connection");
	}
		@BeforeTest
		public void beforeTest()
		{
			System.out.println("parallel excecution");
		}
@BeforeClass(groups= {"smokeTest","regressionTest"})
public void beforeClass() throws Throwable
{
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
	System.out.println("Launching browser");
	sdriver=driver;
}
@BeforeMethod(groups= {"smokeTest","regressionTest"})
public void beforeMethod() throws Throwable
{
	WebDriver_Utility wlib = new WebDriver_Utility();
	wlib.maximizeScreen(driver);
			File_Utility flib=new File_Utility();
			
			String URL = flib.getStringKeyAndValue("url");
			String USERNAME = flib.getStringKeyAndValue("username");
			String PASSWORD = flib.getStringKeyAndValue("password");
			driver.get(URL);
			LoginPage login = new LoginPage(driver);
			login.loginToApp(USERNAME, PASSWORD);
			
}
@AfterMethod(groups= {"smokeTest","regressionTest"})
public void afterMethod()
{
	HomePage home = new HomePage(driver);
	home.logout(driver);
	
}
@AfterTest(groups= {"smokeTest","regressionTest"})
public void afterTest()
{
	System.out.println("parallel excecution done");
}
@AfterClass(groups= {"smokeTest","regressionTest"})
public void afterclass()
{
	driver.close();
	//System.out.println("close the browser");
}
@AfterSuite(groups= {"smokeTest","regressionTest"})
public void afterSuite()
{
	System.out.println("Database Close");
}
}
