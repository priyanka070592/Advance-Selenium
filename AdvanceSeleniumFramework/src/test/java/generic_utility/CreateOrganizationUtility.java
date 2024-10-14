package generic_utility;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
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

public class CreateOrganizationUtility {

public static void main(String[] args) throws Throwable {

			WebDriver driver = new ChromeDriver();

			File_Utility flib = new File_Utility();
			Java_Utility jlib = new Java_Utility();
			Excel_Utility elib = new Excel_Utility();

			String URL = flib.getKeyAndValuePair("url");
			String USERNAME = flib.getKeyAndValuePair("username");
			String PASSWORD = flib.getKeyAndValuePair("password");

			driver.get(URL);
			driver.findElement(By.cssSelector("[name='user_name']")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.linkText("Organizations")).click();

			driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();

			int ranNum = jlib.getRandonNum();

			String OrgName = elib.getExcelData("Organization", 0, 0) +ranNum;
			String phneNumber = elib.getExcelDataUsingDataFormatter("Organization", 1, 0);
			String email = elib.getExcelDataUsingDataFormatter("Organization", 2, 0);

			driver.findElement(By.name("accountname")).sendKeys(OrgName);

			driver.findElement(By.id("phone")).sendKeys(phneNumber);

			driver.findElement(By.id("email1")).sendKeys(email);

			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

			Thread.sleep(2000);
			String actdata = driver.findElement(By.xpath("//span[@id=\"dtlview_Organization Name\"]")).getText();

			if (actdata.contains(OrgName)) {
				System.out.println("Organization name is created");
			} else {
				System.out.println("Organization name not created");
			}
			
			driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
			driver.findElement(By.linkText("Sign Out")).click();
		}

	}
