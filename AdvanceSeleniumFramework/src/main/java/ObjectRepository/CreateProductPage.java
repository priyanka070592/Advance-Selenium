package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {


	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement productPlusSign;
  
	@FindBy(name="productname")
	private WebElement productNameTextField;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getProductPlusSign() {
		return productPlusSign;
	}

	public WebElement getProductNameTextField() {
		return productNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void clickOnPlusSign()
	{
		productPlusSign.click();
	}
	public void enterProductName(String prdName)
	{
		productNameTextField.sendKeys(prdName);
	}
	public void clickSaveButton()
	{
		saveButton.click();
	}
	
}
