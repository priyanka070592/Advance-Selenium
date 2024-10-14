package ObjectRepository;

import javax.swing.text.Element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class VtigerLoginPage {

	// Element initialization
	public VtigerLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Declaration

	@FindBy(name = "user_name")
	private WebElement userTextField;

	// AND
//	@FindBys({@FindBy(css = "[type=\"password\"]"),@FindBy(name = "user_password")})
	@FindBy(name = "user_password")
	private WebElement passWordTextField;

	// OR
	@FindAll({ @FindBy(xpath = "//input[@type=\"submit\"]"), @FindBy(id = "submitButton") })
	private WebElement loginButton;

	// getter methods
	public WebElement getUserTextField() {
		return userTextField;
	}

	public WebElement getPassWordTextField() {
		return passWordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	// Business Libaries/Logics
	
	/**
	 * This method is used to login to vtiger app
	 * @param Username
	 * @param Password
	 * @author Priyanka Sharma
	 */

	public void loginToVitger(String Username, String Password) {
		userTextField.sendKeys(Username);
		passWordTextField.sendKeys(Password);
		loginButton.click();
	}

}