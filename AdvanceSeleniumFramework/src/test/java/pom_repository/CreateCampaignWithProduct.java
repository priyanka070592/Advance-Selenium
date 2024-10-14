package pom_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ObjectRepository.CreateCampaignPage;
import ObjectRepository.CreateProductPage;
import ObjectRepository.HomePage;
import ObjectRepository.ValidationAndVerification;
import ObjectRepository.VtigerLoginPage;
import ObjectRepository.WindowSwitingToProductPage;
import generic_utility.Excel_Utility;
import generic_utility.File_Utility;
import generic_utility.Java_Utility;
import generic_utility.Webdriver_Utility;

public class CreateCampaignWithProduct {

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
		 wlib.pageToLoad(driver);
        driver.get(URL);
        VtigerLoginPage login = new VtigerLoginPage(driver);
		login.loginToVitger(USERNAME, PASSWORD);
        int ranNumber = jlib.getRandonNum();
        HomePage home = new HomePage(driver);
        home.clickPrdLink();
       CreateProductPage prdPage = new CreateProductPage(driver);
        prdPage.clickOnPlusSign();
      String productData = elib.getExcelData("Product", 0, 0)+ranNumber;
	  prdPage.enterProductName(productData);
	  prdPage.clickSaveButton();
      home.clickMoreLink();
      home.clickCampLink();
      CreateCampaignPage campPage = new CreateCampaignPage(driver);
      campPage.clickCampPlusSign();
      String campaignData = elib.getExcelData("Campaign", 0, 0)+ranNumber;
         campPage.enterCampName(campaignData);
         campPage.clickProductPlusSign();
         wlib.windowSwitching(driver, "Products&action");
         WindowSwitingToProductPage campPrdPage = new WindowSwitingToProductPage(driver);
         campPrdPage.enterProductName(productData);
         campPrdPage.searchPrdName();
         campPrdPage.prdNamePresent(driver, productData);
         wlib.windowSwitching(driver, "Campaigns&action");
         campPage.clickOnSaveButton();
    ValidationAndVerification campProdValidation = new ValidationAndVerification(driver);
   campProdValidation.campData(driver, campaignData);
   campProdValidation.productInCamp(driver, productData);
   home.logOutFromApp();
	
	}

}
