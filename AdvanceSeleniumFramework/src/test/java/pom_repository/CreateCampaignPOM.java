package pom_repository;

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

import ObjectRepository.VtigerLoginPage;
import generic_utility.Excel_Utility;
import generic_utility.File_Utility;
import generic_utility.Java_Utility;

public class CreateCampaignPOM {

	public static void main(String[] args) throws Throwable {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		File_Utility file = new File_Utility();
		String URL = file.getKeyAndValuePair("url");
		String USERNAME = file.getKeyAndValuePair("username");
		String PASSWORD = file.getKeyAndValuePair("password");

		driver.get(URL);

		//Reading Data using getter methods
//		VtigerLoginPage login = new VtigerLoginPage(driver);
//		login.getUserTextField().sendKeys(USERNAME);
//		login.getPassWordTextField().sendKeys(PASSWORD);
//		login.getLoginButton().click();
		
		//Business Logics
		VtigerLoginPage login = new VtigerLoginPage(driver);
		login.loginToVitger(USERNAME, PASSWORD);
		
		WebElement moreLink = driver.findElement(By.linkText("More"));
		Actions act = new Actions(driver);
		act.moveToElement(moreLink).perform();

		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();

		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandonNum();

		Excel_Utility elib = new Excel_Utility();
		String campData = elib.getExcelData("Campaign", 0, 0) + ranNum;
		System.out.println(campData);

		driver.findElement(By.name("campaignname")).sendKeys(campData);
		driver.findElement(By.cssSelector("[title=\"Save [Alt+S]\"]")).click();

		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();

		if (actData.contains(campData)) {
			System.out.println("campaigns name is created");
		} else {
			System.out.println("campaigns name is not created");
		}

		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();
	}

}