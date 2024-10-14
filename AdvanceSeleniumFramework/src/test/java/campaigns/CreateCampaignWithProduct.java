package campaigns;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateCampaignWithProduct {

	public static void main(String[] args) throws Throwable {
//		WebDriver driver=new ChromeDriver();
		// Step1:- Create a object of FileInStream class(connection of physical file
		// path)
		FileInputStream fis = new FileInputStream("./src/test/resources/PropertiesData.properties");

		// step2:- load all the keys to Properties class
		Properties pro = new Properties();
		pro.load(fis);

		// Step3:- call keys from properties file
		String BROWSER = pro.getProperty("browser");
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");

		WebDriver driver;

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new FirefoxDriver();
		}

		driver.get(URL);
		driver.findElement(By.cssSelector("[name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();

		Random ran = new Random();
		int ranNum = ran.nextInt(1000);

		// step1:- path connection
		FileInputStream fis1 = new FileInputStream("./src/test/resources/TestSheet.xlsx");

		// step2:- excel file in read mode
		Workbook book = WorkbookFactory.create(fis1);

		// step3:- get control on sheet
		Sheet sheet = book.getSheet("Product");

		// step4:- get control on row
		Row row = sheet.getRow(0);

		// step5:- get control on cell
		Cell cell = row.getCell(0);

		// step6:-fetching the cell value
		String prdName = cell.getStringCellValue() + ranNum;
		System.out.println(prdName);

		driver.findElement(By.name("productname")).sendKeys(prdName);

		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();

		// ---------------------------------------------------------------------------------------------------
//Navigating to campaigns module

		WebElement moreLink = driver.findElement(By.linkText("More"));

		Actions act = new Actions(driver);
		act.moveToElement(moreLink).perform();

		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();

//	Random ran = new Random();
//	int ranNum = ran.nextInt(1000);

		

		// step1:- path connection
		FileInputStream fis2 = new FileInputStream("./src/test/resources/TestSheet.xlsx");

		// step2:- excel file in read mode
		Workbook book1 = WorkbookFactory.create(fis2);

		// step3:- get control on sheet
		Sheet sheet1 = book1.getSheet("Campaign");

		// step4:- get control on row
		Row row1 = sheet1.getRow(0);

		// step5:- get control on cell
		Cell cell1 = row1.getCell(0);

		// step6:-fetching the cell value
		String campData = cell1.getStringCellValue() + ranNum;
		System.out.println(campData);

		driver.findElement(By.name("campaignname")).sendKeys(campData);
		// -----------------------------------------------------------------------
//window switching
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/select.gif\"]")).click();

		Set<String> allWins = driver.getWindowHandles();

		Iterator<String> it = allWins.iterator();

		while (it.hasNext()) {
			String win = it.next();
			driver.switchTo().window(win);
			String title = driver.getTitle();

			if (title.contains("Products&action")) {
				break;
			}
		}

		driver.findElement(By.name("search_text")).sendKeys(prdName);
		driver.findElement(By.name("search")).click();

		// driver.findElement(By.xpath("//a[text()='Iphone61']")).click();

		Thread.sleep(2000);
		// dynamic xapth
		driver.findElement(By.xpath("//a[text()='" + prdName + "']")).click();
		// -+-----------------------------------------------------------------------------------------------
		// driver switching back to main win
		Set<String> allWins1 = driver.getWindowHandles();

		Iterator<String> it1 = allWins1.iterator();

		while (it1.hasNext()) {
			String win1 = it1.next();
			driver.switchTo().window(win1);
			String title1 = driver.getTitle();

			if (title1.contains("Campaigns&action")) {
				break;
			}
		}
		driver.findElement(By.cssSelector("[title=\"Save [Alt+S]\"]")).click();
	}
}
