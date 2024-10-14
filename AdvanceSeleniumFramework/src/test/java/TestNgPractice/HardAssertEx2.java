package TestNgPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertEx2 {

	@Test
	public void login() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");

		WebElement UserText = driver.findElement(By.name("user_name"));
		
         //Assert.assertTrue(UserText.isDisplayed(), "Assert Pass");
		Assert.assertTrue(UserText.isDisplayed());
		UserText.sendKeys("admin");

		WebElement PassWordText = driver.findElement(By.name("user_password"));
		//Assert.assertTrue(PassWordText.isDisplayed(), "Assert Failed");
		Assert.assertTrue(PassWordText.isDisplayed());
		

		PassWordText.sendKeys("Krishna@1992");

		driver.findElement(By.id("submitButton")).click();

	}

}