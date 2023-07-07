package OrganizationPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
//Declaration
	@FindBy(name="user_name")
	private WebElement userNameTextField;
	@FindBy(name="user_password")
	private WebElement passwordTextField;
	@FindBy(id="submitButton")
	private WebElement loginButton;
	//getter methods
	public WebElement getUserNameTextField() {
		return userNameTextField;
	}
	public WebElement getPasswordTextField() {
		return passwordTextField;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}
	//Business Logics
	public void loginToApp(String userName,String Password)
	{
		userNameTextField.sendKeys(userName);
		passwordTextField.sendKeys(Password);
		loginButton.click();
	}
	
	
	
	
	

	

}
