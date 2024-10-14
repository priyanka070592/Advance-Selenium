package pom_repository;

import java.io.FileInputStream;
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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import generic_utility.Excel_Utility;
import generic_utility.File_Utility;
import generic_utility.Java_Utility;
import generic_utility.Webdriver_Utility;
import ObjectRepository.CreateOrganizaationPage;
import ObjectRepository.HomePage;
import ObjectRepository.VtigerLoginPage;

public class CreateOrganization {

	public static void main(String[] args) throws Throwable {
	
		

		File_Utility flib = new File_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();
		Webdriver_Utility wlib = new Webdriver_Utility();
		
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
		 else if(BROWSER.equalsIgnoreCase("edge"))
		 {
			 driver=new EdgeDriver();
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
  home.clickOrgLink();
 
  CreateOrganizaationPage orgPage = new CreateOrganizaationPage(driver);
  orgPage.clickOrgPlusSign();
  int ranNum = jlib.getRandonNum();
  String organizationData = elib.getExcelDataUsingDataFormatter("Organization", 0, 0)+ranNum;
  String phoneNum = elib.getExcelDataUsingDataFormatter("Organization", 1, 0);
  String emailId = elib.getExcelDataUsingDataFormatter("Organization", 2, 0); 
  orgPage.orgData(organizationData, phoneNum, emailId);
  orgPage.clickOnSaveButton();
  Thread.sleep(2000);
  home.clickOnAdmLink();
  home.ClickSignOutLink();
	}

}
