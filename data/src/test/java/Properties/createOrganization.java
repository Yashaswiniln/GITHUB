package Properties;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import OrganizationPom.HomePage;
import OrganizationPom.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class createOrganization {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
FileInputStream fis = new	 FileInputStream("src/test/resources/com.properties.txt");
	  Properties pro= new Properties();
	  pro.load(fis);
	String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		driver.get("URL");
//driver.findElement(By.name("user_name")).sendKeys(USERNAME);

//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//driver.findElement(By.id("submitButton")).click();
LoginPage login = new LoginPage(driver);
login.loginToApp(USERNAME, PASSWORD);
login.getLoginButton().click();
HomePage home = new HomePage(driver);
home.organizationLink();
//driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME,Keys.TAB,PASSWORD,Keys.ENTER);
driver.findElement(By.xpath("//a[text()='Organizations']")).click();
//driver.findElement(By.linkText("Organizations"));
driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
Random r=new Random();
int ranNum = r.nextInt(1000);

WebElement orgName = driver.findElement(By.xpath("/user_password/input[@name='accountname']"));
orgName.sendKeys("iii"+ranNum);
driver.findElement(By.id("phone")).sendKeys("7483511948");
driver.findElement(By.id("email1")).sendKeys("yashuln98@gmail.com");
Thread.sleep(3000);
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
driver.findElement(By.xpath("//a[text()='Sign Out")).click();
	}
}


	


