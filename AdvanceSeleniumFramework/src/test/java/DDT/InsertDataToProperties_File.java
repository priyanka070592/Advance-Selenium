package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InsertDataToProperties_File {

	public static void main(String[] args) throws Throwable {
//Inserting data to Properties File
		Properties pro1 = new Properties();
		pro1.setProperty("Browser", "chrome");
		pro1.setProperty("url", "http://localhost:8888/");
        pro1.setProperty("username", "admin");
		pro1.setProperty("password", "admin");
	
		//Properties File in write mode
		FileOutputStream fos = new FileOutputStream("./src/test/resources/PropertiesData.properties.txt");
		//pro1.store(fos, "CommonDataStore");
//--------------------------------------------------------------------------------------------------------
		//Step1:- Create a object of FileInStream class(connection of physical file path)
				FileInputStream fis = new FileInputStream("./src/test/resources/PropertiesDatas.properties");

				//step2:- load all the keys to Properties class
				Properties pro = new Properties();
				pro.load(fis);
			
				//Step3:- call keys from properties file
				String BROWSER = pro.getProperty("Browser");
				String URL = pro.getProperty("url");
				String USERNAME = pro.getProperty("username");
			    String PASSWORD = pro.getProperty("password");
				
			    WebDriver driver;
				
				if(BROWSER.equalsIgnoreCase("chrome"))
				{
					driver=new ChromeDriver();
				}
				else if(BROWSER.equalsIgnoreCase("firefox"))
				{
					driver=new FirefoxDriver();
				}
				else if (BROWSER.equalsIgnoreCase("edge"))
				{
					driver=new EdgeDriver();
				}
				else
				{
					driver=new FirefoxDriver();
				}
				
				driver.get(URL);
				driver.findElement(By.cssSelector("[name='user_name']")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
	
	}

}