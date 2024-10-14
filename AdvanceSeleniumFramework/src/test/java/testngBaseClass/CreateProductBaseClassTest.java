package testngBaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import ObjectRepository.HomePage;
import ObjectRepository.VtigerLoginPage;
import generic_utility.BaseClass;
import generic_utility.Excel_Utility;
import generic_utility.File_Utility;
import generic_utility.Java_Utility;
import generic_utility.Webdriver_Utility;
import pom_repository.CreateProduct;

public class CreateProductBaseClassTest extends BaseClass {

	@Test(groups = {"smokeTest","regressionTest","sanityTest"})
	public void createProductBaseClassTest() throws Throwable {

		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();

		Random ran = new Random();
		int ranNum = ran.nextInt(1000);

		
		Excel_Utility elib = new Excel_Utility();
		String productData = elib.getExcelData("Product", 0, 0)+ranNum;
		

		driver.findElement(By.name("productname")).sendKeys(productData);

		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();

		Thread.sleep(2000);
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();

		if (actData.contains(productData)) 
		{
			System.out.println("product name is created");
		} else 
		{
			System.out.println("product name not created");
		}
			
	}

}
	

