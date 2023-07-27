package pageObjects;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import managers.ExecutionTimeException;

public class BasePage {

	static WebDriver driver;

	public BasePage() {
	}

	public static void basePageDriver(WebDriver driver1) {
		driver = driver1;
	}

	public void object_Click(WebElement element) 
	{
		try 
		{
			element.click();
		} 
		catch (Exception e) 
		{
			throw new ExecutionTimeException("Login textbox is absent / got changed on the webpage.");
		}
	}

	public WebElement waitVisibleElement(WebElement element, int time) 
	{
		return new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.visibilityOf(element));
	}

	public WebElement waitClickableElement(WebElement element, int time) 
	{
		return new WebDriverWait(driver, Duration.ofSeconds(time))
				.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void selectOptionByText(WebElement ele, String text)
	{
		try
		{
		new Select(ele).selectByVisibleText(text);
		}
		catch(Exception e)
		{
		System.out.println(e.getMessage());	
		}
	}

	public void selectOptionByIndex(WebElement ele, int index) {
		try
		{
		new Select(ele).selectByIndex(index);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			
		}
	}

	public void scrollToElement(WebElement ele) 
	{
		try
		{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	public void takeScreenshot() {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			Date dateTime = new Date();
			String screenshotPath = "test-output/screenshots/" + dateTime.getDate() + "-" + dateTime.getMonth() + " "
					+ dateTime.getHours() + "-" + dateTime.getMinutes() + "-" + dateTime.getSeconds() + ".png";
			FileUtils.copyFile(file, new File(screenshotPath));
		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}

}