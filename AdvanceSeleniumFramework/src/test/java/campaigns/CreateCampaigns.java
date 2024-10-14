package campaigns;

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

public class CreateCampaigns {

	public static void main(String[] args) throws Throwable {


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

		WebDriver driver = new ChromeDriver();
		

//				if(BROWSER.equalsIgnoreCase("chrome"))
//				{
//					driver=new ChromeDriver();
//				}
//				else if(BROWSER.equalsIgnoreCase("firefox"))
//				{
//					driver=new FirefoxDriver();
//				}
//				else if (BROWSER.equalsIgnoreCase("edge"))
//				{
//					driver=new EdgeDriver();
//				}
//				else
//				{
//					driver=new FirefoxDriver();
//				}

		driver.get(URL);
		driver.findElement(By.cssSelector("[name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		WebElement moreLink = driver.findElement(By.linkText("More"));

		Actions act = new Actions(driver);
		act.moveToElement(moreLink).perform();

		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();

		Random ran = new Random();
		int ranNum = ran.nextInt(1000);

		// step1:- path connection
		FileInputStream fis1 = new FileInputStream("./src/test/resources/TestSheet.xlsx");

		// step2:- excel file in read mode
		Workbook book = WorkbookFactory.create(fis1);

		// step3:- get control on sheet
		Sheet sheet = book.getSheet("Campaign");

		// step4:- get control on row
		Row row = sheet.getRow(0);

		// step5:- get control on cell
		Cell cell = row.getCell(0);

		// step6:-fetching the cell value
		String campData = cell.getStringCellValue() + ranNum;
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
