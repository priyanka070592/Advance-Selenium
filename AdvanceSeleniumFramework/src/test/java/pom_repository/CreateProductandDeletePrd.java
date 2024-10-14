package pom_repository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
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
import org.openqa.selenium.firefox.FirefoxDriver;

import ObjectRepository.CreateProductPage;
import ObjectRepository.DeletePrdValidationPage;
import ObjectRepository.HomePage;
import ObjectRepository.VtigerLoginPage;
import generic_utility.Excel_Utility;
import generic_utility.File_Utility;
import generic_utility.Java_Utility;
import generic_utility.Webdriver_Utility;



public class CreateProductandDeletePrd {

	public static void main(String[] args) throws Throwable {
		
		 File_Utility flib = new File_Utility();
		 Webdriver_Utility wlib = new Webdriver_Utility();
		 Java_Utility jlib = new Java_Utility();
		 Excel_Utility elib = new Excel_Utility();
		 
		 WebDriver driver;
		 String BROWSER = flib.getKeyAndValuePair("browser");
		 if(BROWSER.equalsIgnoreCase("chrome"))
		 {
			  driver=new ChromeDriver();
		 }
		 else if(BROWSER.equalsIgnoreCase("fireFox"))
		 {
			 driver=new FirefoxDriver();
		 }
		 else
		 {
			 driver=new ChromeDriver();
		 }
	     String URL = flib.getKeyAndValuePair("url");
		 String USERNAME = flib.getKeyAndValuePair("username");
		 String PASSWORD = flib.getKeyAndValuePair("password");
		
		 wlib.maximizeWindow(driver);
		 wlib.elementsToGetLoaded(driver);
		 driver.get(URL);
		
		 VtigerLoginPage login = new VtigerLoginPage(driver);
		 login.loginToVitger(USERNAME, PASSWORD);
	    
		HomePage home = new HomePage(driver);
		home.clickPrdLink();
		
	//	driver.findElement(By.linkText("Products")).click();
		//driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
	   CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.clickOnPlusSign();
		
		int ranNumber = jlib.getRandonNum();
	
	  String productData = elib.getExcelDataUsingDataFormatter("Product", 0, 0)+ranNumber;
//	 driver.findElement(By.name("productname")).sendKeys(productData);
	prdPage.enterProductName(productData);
	
//	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();    
	prdPage.clickSaveButton();
	
//	driver.findElement(By.linkText("Products")).click(); 
	home.clickPrdLink();
//	 driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='Product Name']/../preceding-sibling::td//input[@type='checkbox']")).click();
	    
	DeletePrdValidationPage prdValidate = new DeletePrdValidationPage(driver);
	// driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='"+productData+"']/../preceding-sibling::td//input[@type='checkbox']")).click();
	 prdValidate.deleteProduct(driver, productData);
	 
	// driver.findElement(By.xpath("//input[@value='Delete']")).click();
	 prdValidate.clickOnDeleteButton(wlib, driver);
	
	//	  List<WebElement> productList = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]")); 
//	    	
//	boolean flag = false;
//	
//	for (WebElement prdName : productList)
//	{
//		String actData = prdName.getText();
//		if(actData.contains(productData))
//		{
//			flag=true;
//		   break;
//		}}
//	if(flag)
//	{
//		System.out.println("product data is deleted");
//	}
//	else
//	{
//		System.out.println("product data is not deleted");
//	}
	// System.out.println("pdata"+productData);
	 prdValidate.validateProductDeleted(driver, productData);
//	wlib.alertAccept(driver);
//      driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//      driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
      home.logOutFromApp();
	}

}
