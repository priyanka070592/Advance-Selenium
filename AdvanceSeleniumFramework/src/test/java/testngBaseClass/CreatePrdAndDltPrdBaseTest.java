package testngBaseClass;

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
import org.testng.annotations.Test;

import ObjectRepository.CreateProductPage;
import ObjectRepository.DeletePrdValidationPage;
import ObjectRepository.HomePage;
import ObjectRepository.VtigerLoginPage;
import generic_utility.BaseClass;
import generic_utility.Excel_Utility;
import generic_utility.File_Utility;
import generic_utility.Java_Utility;
import generic_utility.Webdriver_Utility;

public class CreatePrdAndDltPrdBaseTest extends BaseClass {

	@Test(groups = {"smokeTest","regressionTest","sanityTest"})
	public void CreatePrdAndDltPrdBaseTest() throws Throwable {

		File_Utility flib = new File_Utility();
		Webdriver_Utility wlib = new Webdriver_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();

		HomePage home = new HomePage(driver);
		home.clickPrdLink();

		CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.clickOnPlusSign();

		int ranNumber = jlib.getRandonNum();

		String productData = elib.getExcelDataUsingDataFormatter("Product", 0, 0) + ranNumber;

		prdPage.enterProductName(productData);

		prdPage.clickSaveButton();

		home.clickPrdLink();

		DeletePrdValidationPage prdValidate = new DeletePrdValidationPage(driver);

		prdValidate.deleteProduct(driver, productData);

		prdValidate.clickOnDeleteButton(wlib, driver);

	}

}
