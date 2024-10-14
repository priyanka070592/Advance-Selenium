package pom_repository;

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

import ObjectRepository.HomePage;
import ObjectRepository.VtigerLoginPage;
import generic_utility.Excel_Utility;
import generic_utility.File_Utility;
import generic_utility.Java_Utility;
import generic_utility.Webdriver_Utility;



public class CreateProduct {

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
      
		int ranNum = jlib.getRandonNum();
    
		HomePage home = new HomePage(driver);
		home.clickPrdLink();
		
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
	
	
	String productData = elib.getExcelData("Product", 0, 0)+ranNum;
	driver.findElement(By.name("productname")).sendKeys(productData);
 
    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
    driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}

}
