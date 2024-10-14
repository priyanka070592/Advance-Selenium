package product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class CreateProductAndDeleteProduct {

	public static void main(String[] args) throws Throwable {
		
		 WebDriver driver=new ChromeDriver();

		    FileInputStream fis = new FileInputStream("./src/test/resources/PropertiesData.properties");

			//step2:- load all the keys to Properties class
			Properties pro = new Properties();
			pro.load(fis);

			//Step3:- call keys from properties file
			String BROWSER = pro.getProperty("browser");
			String URL = pro.getProperty("url");
			String USERNAME = pro.getProperty("username");
		    String PASSWORD = pro.getProperty("password");

		    driver.get(URL);
			driver.findElement(By.cssSelector("[name='user_name']")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			
			driver.findElement(By.linkText("Products")).click();
			driver.findElement(By.cssSelector("[title=\"Create Product...\"]")).click();
			
			Random ran = new Random();
			int ranNum = ran.nextInt(1000);
			
			//step1:- path connection
			FileInputStream fis1 = new FileInputStream("./src/test/resources/TestSheet.xlsx");

			       //step2:- excel file in read mode
				Workbook book = WorkbookFactory.create(fis1);
				  
				//step3:- get control on sheet
				Sheet sheet = book.getSheet("Product");
				
				//step4:- get control on row
				Row row = sheet.getRow(0);
				
				//step5:- get control on cell
				Cell cell = row.getCell(0);
				
				//step6:-fetching the cell value
				String prdName = cell.getStringCellValue()+ranNum;
				System.out.println(prdName);
				
				driver.findElement(By.name("productname")).sendKeys(prdName);
				
				driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
	//----------------------------------------------------------------------------------------------------
				//navigating the product table
				driver.findElement(By.xpath("//a[text()='Products']")).click();
				
//driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='Product Name']/../preceding-sibling::td//input[@type='checkbox']")).click();
	
				//Dynamic Xpath
driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='"+prdName+"']/../preceding-sibling::td//input[@type='checkbox']")).click();			
Thread.sleep(1000);
driver.findElement(By.xpath("//input[@value='Delete']")).click();

driver.switchTo().alert().accept();

List<WebElement> productList = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));

boolean flag=false;
	 	 for(WebElement prdName1:productList)
	 {
		String actData = prdName1.getText();
		if(actData.contains(prdName))
		{
			flag=true;
			break;
		}
	 }
	if(flag)
	{
		System.out.println("product data is deleted");
	}
	else
	{
		System.out.println("product data not deleted");
	}
Thread.sleep(1000);	
driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
driver.findElement(By.linkText("Sign Out")).click();
	}

}

