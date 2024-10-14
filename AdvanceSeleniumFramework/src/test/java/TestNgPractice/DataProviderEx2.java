package TestNgPractice;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx2 {
	
@Test(dataProvider="getdata")
	public void data(String orgName, String phno, String email) throws Throwable
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("Krishna@1992");
	    driver.findElement(By.id("submitButton")).click();
	    driver.findElement(By.linkText("Organizations")).click();
	    driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	    driver.findElement(By.name("accountname")).sendKeys(orgName);
	    driver.findElement(By.id("phone")).sendKeys(phno);
	    driver.findElement(By.id("email1")).sendKeys(email);
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
	    driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	    Thread.sleep(1000);
	    driver.quit();
	}

@DataProvider
public Object[][] getdata()
{
	Object[][] objArr = new Object[3][3];
	Random ranNum = new Random();
	int ranNumber = ranNum.nextInt(1000);
	objArr[0][0]="AAA"+ranNumber;
	objArr[0][1]="6956451665";
	objArr[0][2]="mailto:abc@gmail.com";
	
	objArr[1][0]="BBB"+ranNumber;
	objArr[1][1]="6956451665";
	objArr[1][2]="mailto:abcd@gmail.com";
	
	objArr[2][0]="CCC"+ranNumber;
	objArr[2][1]="6956451665";
	objArr[2][2]="mailto:abce@gmail.com";
	
	return objArr;
	
}
}