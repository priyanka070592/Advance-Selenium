package testngBaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ObjectRepository.CreateCampaignPage;
import ObjectRepository.HomePage;
import ObjectRepository.ValidatingPage;
import ObjectRepository.VtigerLoginPage;
import generic_utility.BaseClass;
import generic_utility.Excel_Utility;
import generic_utility.File_Utility;
import generic_utility.Java_Utility;
import generic_utility.Webdriver_Utility;



//@Listeners(generic_utility.ExtentReport.class)
public class CreateCampaignsTest extends BaseClass {

//	  @Test(groups = "smokeTest")
	@Test(retryAnalyzer = generic_utility.RetryImp.class)
	public void createCampaignsTest() throws Throwable {

		Webdriver_Utility wlib = new Webdriver_Utility();
        File_Utility file = new File_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();

		HomePage home = new HomePage(driver);

		home.naviagteCamp(driver);

		CreateCampaignPage campPage = new CreateCampaignPage(driver);
		campPage.clickCampPlusSign();

		//Assert.fail("I am failing the script");
		int ranNum = jlib.getRandonNum();

		String campData = elib.getExcelData("Campaign", 0, 0) + ranNum;
		System.out.println(campData);

		campPage.enterCampName(campData);
		campPage.clickOnSaveButton();

		ValidatingPage validate = new ValidatingPage(driver);
		validate.validateCampPage(driver, campData);
//		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
//        Assert.assertEquals(actData, campData);
	
	
	}
//-----------------------------------------------------------------------------	
	

}