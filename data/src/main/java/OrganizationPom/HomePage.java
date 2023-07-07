package OrganizationPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	//initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Declaration
	@FindBy(xpath="//a[text()='Organizations']")
	
	
		private WebElement OrganizationLink;
	//@FindBy(linkText="Products")
@FindBy(xpath="//a[text()='Products']")
	private WebElement ProductsLink;
@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
private WebElement Administrator;
@FindBy(xpath="//a[text()='Sign Out']")
private WebElement signout;

		//getter method
		public WebElement getOrganizationLink() {
			return OrganizationLink;
		}
			public WebElement getProductsLink() {
				return ProductsLink;
			}
			
	public WebElement getAdministrator() {
				return Administrator;
			}
			public void setAdministrator(WebElement administrator) {
				Administrator = administrator;
			}
public WebElement getSignout() {
				return signout;
			}
			
//business logic	
public void organizationLink()
{
	OrganizationLink.click();
}
	
	//Declaration
	//@FindBy(linkText="Products")

public void ProductsLink()
{
	
	ProductsLink.click();
}
public void logout(WebDriver driver) {
//WebDriver_Utility wlib = new WebDriver_Utility();
//	wlib.
	Actions act=new Actions(driver);
	act.moveToElement(Administrator).perform();
	signout.click();
}
}
