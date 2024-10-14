package Practice;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenShotYoutubeEx {

	public static void main(String[] args) throws Throwable {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		WebElement searchbox = driver.findElement(By.name("q"));
		
		searchbox.sendKeys("Youtube");
		searchbox.submit();
		Thread.sleep(1000);
		
		
		//TakesScreenshot ts = (TakesScreenshot)driver;
		//File src = ts.getScreenshotAs(OutputType.FILE);
		

	}

}
