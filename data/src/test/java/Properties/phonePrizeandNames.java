package Properties;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;


public class phonePrizeandNames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	WebDriver driver=new EdgeDriver();
	driver.get("https://www.flipkart.com/search?q=iphone13&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off&as-pos=1&as-type=HISTORY");
	 List<WebElement> names = driver.findElements(By.xpath("//div[@class='col col-7-12']/div[@class='_4rR01T']"));
 List<WebElement> price = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
for(int i=0;i<names.size();i++)
{
	System.out.println(names.get(i).getText()+"\t"+price.get(i).getText());
}
	}

}
