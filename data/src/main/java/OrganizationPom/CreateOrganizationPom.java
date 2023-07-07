package OrganizationPom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPom {
	//initialization
	public CreateOrganizationPom(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement clicking;
	@FindBy(name="accountname")
	private WebElement 	Orgname;
	@FindBy(id="phone")
	private WebElement 	OrgPhone;
	@FindBy(id="email1")
	private WebElement 	OrgEmail;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	//getter
	public WebElement getClicking() 
	 {
			return clicking;
		}
	
	public WebElement getSaveButton() {
		return saveButton;
	}
 WebElement getOrgname() {
		return Orgname;
	}
public WebElement getOrgPhone() {
		return OrgPhone;
	}
public WebElement getOrgEmail() {
		return OrgEmail;
	}
//business logic
public void clickOnImg()
{
	clicking.click();
}
	public void orgData(String orgName,String phonenum,String email)
	{
	Orgname.sendKeys(orgName);
	Orgname.sendKeys(phonenum);
	Orgname.sendKeys(email);
	}
	public void clickSaveButton()
	{
		saveButton.click();
	}
}



