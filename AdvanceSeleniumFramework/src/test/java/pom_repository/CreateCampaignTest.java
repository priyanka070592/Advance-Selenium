package pom_repository;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import generic_utility.Excel_Utility;
import generic_utility.File_Utility;
import generic_utility.Java_Utility;
import generic_utility.Webdriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import ObjectRepository.CreateCampaignPage;
import ObjectRepository.HomePage;
import ObjectRepository.ValidationAndVerification;
import ObjectRepository.VtigerLoginPage;

public class CreateCampaignTest {

	public static void main(String[] args) throws Throwable {
		File_Utility flib = new File_Utility();
		 Webdriver_Utility wlib = new Webdriver_Utility();
		 Java_Utility jlib = new Java_Utility();
		 Excel_Utility elib = new Excel_Utility();
		
		 WebDriver driver;
		 String BROWSER = flib.getKeyAndValuePair("browser");
		 if(BROWSER.equalsIgnoreCase("chrome"))
		 {
			 WebDriverManager.chromedriver().setup();
			  driver=new ChromeDriver();
		 }
		 else if(BROWSER.equalsIgnoreCase("fireFox"))
		 {
			 WebDriverManager.firefoxdriver().setup();
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
        home.clickMoreLink();
        home.clickCampLink();
     
        CreateCampaignPage campPage = new CreateCampaignPage(driver);
        campPage.clickCampPlusSign();
        int ranNum = jlib.getRandonNum();
        
        String campaginName = elib.getExcelDataUsingDataFormatter("Campaign", 0, 0)+ranNum;
        campPage.enterCampName(campaginName);
        
        campPage.clickOnSaveButton();

        ValidationAndVerification campvalidate = new ValidationAndVerification(driver);
        campvalidate.campData(driver, campaginName);
    
	   home.clickOnAdmLink();
	   home.ClickSignOutLink();
	}

}
