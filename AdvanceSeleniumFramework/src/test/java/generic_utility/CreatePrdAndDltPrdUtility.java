package generic_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generic_utility.Excel_Utility;
import generic_utility.File_Utility;
import generic_utility.Java_Utility;
import generic_utility.Webdriver_Utility;


public class CreatePrdAndDltPrdUtility {

	public static void main(String[] args) throws Throwable {

		WebDriver driver = new ChromeDriver();

		File_Utility flib = new File_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();
		Webdriver_Utility wlib = new Webdriver_Utility();

		wlib.windowMaximize(driver);
		wlib.pageToLoad(driver);
		String URL = flib.getKeyAndValuePair("url");
		String USERNAME = flib.getKeyAndValuePair("username");
		String PASSWORD = flib.getKeyAndValuePair("password");

		driver.get(URL);
		driver.findElement(By.cssSelector("[name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.cssSelector("[title=\"Create Product...\"]")).click();

		int ranNum = jlib.getRandonNum();

		String prdName = elib.getExcelData("Product", 0, 0) + ranNum;
		driver.findElement(By.name("productname")).sendKeys(prdName);
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();

		// ----------------------------------------------------------------------------------------------------
		// navigating the product table
		driver.findElement(By.xpath("//a[text()='Products']")).click();

//driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='Product Name']/../preceding-sibling::td//input[@type='checkbox']")).click();

		// Dynamic Xpath
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='" + prdName
				+ "']/../preceding-sibling::td//input[@type='checkbox']")).click();

		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		
		wlib.alertAccept(driver);

		List<WebElement> productList = driver
				.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));

		boolean flag = false;
		for (WebElement prdName1 : productList) {
			String actData = prdName1.getText();
			if (actData.contains(prdName)) {
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println("product data is deleted");
		} else {
			System.out.println("product data not deleted");
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		
		
	}

}
