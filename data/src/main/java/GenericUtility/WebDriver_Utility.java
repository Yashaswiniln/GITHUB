package GenericUtility;
import java.time.Duration;
	import java.util.Iterator;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.Alert;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedCondition;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.FluentWait;
	import org.openqa.selenium.support.ui.Select;

	public class WebDriver_Utility {
		
		/**
		 * This method is used to maximizing the screen
		 * @param driver
		 */
		
		public void maximizeScreen(WebDriver driver) {
			driver.manage().window().maximize();
		}
		/**
		 * This method is used to give the implicit wait 
		 * @param driver
		 */
	/*	public void impilicitwait(WebDriver driver) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}*/
		public void scriptTimeout(WebDriver driver) {
			
			driver.manage().timeouts().setScriptTimeout(20,TimeUnit.SECONDS);
			
		}
		
		public void waitforElementwithCustomTimeOut(WebDriver driver, WebElement Element, int pollingTime) {
			
			FluentWait wait = new FluentWait(driver);
			wait.pollingEvery(Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Element));
			
		}
		
		public void switchToWindow(WebDriver driver,String PartialWindowTitle) {
		
			
			Set<String> allid = driver.getWindowHandles();
			Iterator<String> it = allid.iterator();
			while(it.hasNext()) {
				
				String wid=it.next();
				driver.switchTo().window(wid);
				if(driver.getTitle().contains(PartialWindowTitle)) {
					break;
				}
				
			}
		}
		
		public void ActionsMoveToElement(WebDriver driver,WebElement ele) {
			Actions act= new Actions(driver);
			act.moveToElement(ele).perform();
		}
		

		public void switchToAlertAndDismiss(WebDriver driver) {
			driver.switchTo().alert().dismiss();
		}
		public void switchToAlertAndDelete(WebDriver driver) {
			Alert alrt = driver.switchTo().alert();
		}
		
		public void javaScriptExecutor(WebDriver driver,WebElement element) {
			
			
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView()",element );
		}
		
		public void Alertaccept(WebDriver driver) {
			Alert alrt = driver.switchTo().alert();
			  
			alrt.accept();
		}
		
		public void Alertdismiss(WebDriver driver) {
			Alert alrt = driver.switchTo().alert();
			  
			alrt.dismiss();
		}
		
		public void switchToFrame (WebDriver driver, int index) {
			driver.switchTo().frame(index);
		}
		public void switchToFrame(WebDriver driver, String id_name_attribute) {
			driver.switchTo().frame(id_name_attribute);
			
		}
		public void select(WebElement element, int index) {
		
			
			Select sel = new Select(element);
			sel.selectByIndex(index);
	}
		public void select(WebElement element, String text) {
		
			
			Select sel = new Select(element);
			sel.selectByVisibleText(text);
	}
		
		public void mouseOverOnElement(WebDriver driver,WebElement element) {
			Actions act = new Actions(driver);
			act.moveToElement(element).perform();
		}
		
		public void rightClickOnElement(WebDriver driver,WebElement element) {
			
			Actions act = new Actions(driver);
			act.contextClick(element).perform();
		}
		public void moveByOffest(WebDriver driver,int x,int y) {
			Actions act = new Actions(driver);
			act.moveByOffset(x, y).click().perform();
		
	}
		

	}

	





