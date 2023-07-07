package newOrganization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import GenericUtility.Excel_Utility;
import GenericUtility.File_Utility;
import GenericUtility.Java_Utility;

import GenericUtility.WebDriver_Utility;
import OrganizationPom.CreateOrganizationPom;
import OrganizationPom.HomePage;

import OrganizationPom.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class createorganization1 {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		File_Utility flib=new File_Utility();
		 Java_Utility jlib = new Java_Utility();
Excel_Utility elib = new	Excel_Utility();
//WebDriver_Utility wlib = new Webdriver_Utility();
	String URL = flib.getStringKeyAndValue("url");
		String USERNAME = flib.getStringKeyAndValue("username");
		String PASSWORD = flib.getStringKeyAndValue("password");
		driver.get(URL);
		//CALLING POM
		LoginPage login = new LoginPage(driver);
		login.loginToApp(USERNAME, PASSWORD);
		login.getLoginButton().click();
		//home page
		/*HomePage home = new HomePage(driver);
		home.organizationLink();
	CreateOrganizationPom org = new CreateOrganizationPom(driver);
	org.clickOnImg();*/
		/*driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();*/
		//wlib.maximizeScreen(driver);
	/*	driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();*/
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	int ranNum = jlib.getRandomNum();
	 String orgName = elib.getExcelDataUsingDataFormatter("Page",0, 0)+ranNum;
	driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
	String phoneNum = elib.getExcelDataUsingDataFormatter("Page",1, 0);
	driver.findElement(By.name("phone")).sendKeys(phoneNum);
String email = elib.getExcelDataUsingDataFormatter("Page",2,0);
	driver.findElement(By.name("email1")).sendKeys(email);
//org.orgData(orgName, phoneNum, email);
Thread.sleep(1000);
//org.clickSaveButton();
String actData=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
{
	if(actData.contains(orgName))
	{
		System.out.println("pass");
	}
	else
	{
		System.out.println("fail");
	}
}
//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	Thread.sleep(1000);
//	home.logout(driver);
	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();	
	

		}
}


