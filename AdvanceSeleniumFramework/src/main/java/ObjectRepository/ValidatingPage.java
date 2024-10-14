package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ValidatingPage {

	public ValidatingPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void validateCampPage(WebDriver driver,String campName)
	{
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();

		Assert.assertEquals(actData, campName);
		System.out.println("CampNAme is Created");
//		if (actData.contains(campName)) {
//			System.out.println("campaigns name is created");
//		} else {
//			System.out.println("campaigns name is not created");
//		}
	}
}
