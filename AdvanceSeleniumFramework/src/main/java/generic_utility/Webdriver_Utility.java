package generic_utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mysql.jdbc.Driver;

public class Webdriver_Utility {

	/**
	 * This method is used to maximize the window
	 * 
	 * @param driver
	 */

	public void windowMaximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * waits foe elements to get loaded
	 * 
	 * @param driver
	 */
	public void pageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	/**
	 * cursor move to element
	 * 
	 * @param driver
	 * @param ele
	 */
	public void mouseMoveToElement(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
	}

	/**
	 * switching multiple windows
	 * 
	 * @param driver
	 * @param partialTitle
	 */
	public void windowSwitching(WebDriver driver, String partialTitle) {
		Set<String> allWins = driver.getWindowHandles();

		Iterator<String> it = allWins.iterator();

		while (it.hasNext()) {
			String win = it.next();
			driver.switchTo().window(win);
			String title = driver.getTitle();

			if (title.contains(partialTitle)) {
				break;
			}
		}
	}

	/**
	 * Alert accept
	 * 
	 * @param driver
	 */
	public void alertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * Alert cancel
	 * 
	 * @param driver
	 */
	public void alertDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();

	}
	
	public static String takeScreenShot(WebDriver driver,String ScreenSHotNames) throws Throwable
	{
		
		TakesScreenshot takesSceenShot = (TakesScreenshot)BaseClass.sdriver;
		File src = takesSceenShot.getScreenshotAs(OutputType.FILE);
		File dst = new File("./Screenshots/"+ScreenSHotNames+".png");
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();
		
	}

	/**
	 * used to Switch to Frame Window based on index
	 * 
	 * @param driver
	 * @param index
	 */
	public void swithToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * used to Switch to Frame Window based on id or name attribute
	 * 
	 * @param driver
	 * @param id_name_attribute
	 */
	public void swithToFrame(WebDriver driver, String id_name_attribute) {
		driver.switchTo().frame(id_name_attribute);
	}

	/**
	 * used to select the value from the dropDwon based on index
	 * 
	 * @param driver
	 * @param index
	 */
	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * used to select the value from the dropDwon based on value / option avlaible
	 * in GUI
	 * 
	 * @param element
	 * @param value
	 */
	public void select(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	/**
	 * used to place mouse cursor on specified element
	 * 
	 * @param driver
	 * @param elemnet
	 */
	public void mouseOverOnElement(WebDriver driver, WebElement elemnet) {
		Actions act = new Actions(driver);
		act.moveToElement(elemnet).perform();
	}

	/**
	 * used to right click on specified element
	 * 
	 * @param driver
	 * @param elemnet
	 */

	public void rightClickOnElement(WebDriver driver, WebElement elemnet) {
		Actions act = new Actions(driver);
		act.contextClick(elemnet).perform();
	}

	/**
	 * 
	 * @param driver
	 * @param javaScript
	 */
	public void executeJavaScript(WebDriver driver, String javaScript) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript(javaScript, null);
	}

	/**
	 * pass enter Key appertain in to Browser
	 * 
	 * @param driver
	 */
	public void passEnterKey(WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}



	/**
	 * This method is used to move the cursor to a particular element
	 * 
	 * @param driver
	 * @param ele
	 */
	public void moveToElement(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
	}

	public void maximizeWindow(WebDriver driver) 
		{
		    driver.manage().window().maximize();
		}

	public void elementsToGetLoaded(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

	}

	
		

		    /**
		     * Waits for multiple elements to be visible on the page.
		     * 
		     * @param driver   The WebDriver instance.
		     */
		
			}


	
		

