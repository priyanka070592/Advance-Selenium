package ObjectRepository;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.Webdriver_Utility;

public class DeletePrdValidationPage {

	public DeletePrdValidationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement deleteButton;

	public void deleteProduct(WebDriver driver, String productName) {
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='" + productName
				+ "']/../preceding-sibling::td//input[@type='checkbox']")).click();
	}

	public void clickOnDeleteButton(Webdriver_Utility wlib, WebDriver driver) throws InterruptedException {
		deleteButton.click();
		Thread.sleep(3000);
		wlib.alertAccept(driver);
		Thread.sleep(3000);
	}

	public void validateProductDeleted(WebDriver driver, String productName) {
		boolean flag = false;
		List<WebElement> productList = driver
				.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));
		for (WebElement prdName : productList) {
			String actData = prdName.getText();
			// System.out.println(actData);
			if (actData.contains(productName)) {
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println("product data is not deleted");
		} else {
			System.out.println("product data is deleted");
		}
	}
}
