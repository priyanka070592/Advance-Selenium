package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowSwitingToProductPage {

	public WindowSwitingToProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='search_txt']")
	private WebElement productName;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement productSearch;

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getProductSearch() {
		return productSearch;
	}
	
	public void enterProductName(String prdName)
	{
		productName.sendKeys(prdName);
	}
	public void searchPrdName()
	{
		productSearch.click();
	}
	public void prdNamePresent(WebDriver driver,String productData)
	{
		driver.findElement(By.xpath("//a[text()='"+productData+"']")).click();
	}
	
}
