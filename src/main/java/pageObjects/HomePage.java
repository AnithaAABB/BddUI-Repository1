package pageObjects;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import managers.FileReaderManager;

public class HomePage extends BasePage{

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Dismiss")
	private WebElement dismissBtn;
	
	@FindBy(xpath = "//div[@class='navbar-wrapper']//a[@class='noo-search']")
	private WebElement searchBtn;
	
	@FindBy(linkText = "My Account")
	private WebElement myAccountBtn;
	
	@FindBy(linkText = "Checkout")
	private WebElement checkoutBtn;
	
	@FindBy(xpath = "//input[@name='s']")
	private WebElement searchBox;
	
	public WebElement getSearchBox() {
		return searchBox;
	}
	
	
	public void dismiss_TestPage_info() {
		dismissBtn.click();
	}
	
	public void navigateTo_HomePage() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getHomePageUrl());
		dismissBtn.click();
	}
	
	public void navigateTo_LoginPage() {
		myAccountBtn.click();
	}
	
	public void navigateTo_CheckoutPage() {
		checkoutBtn.click();
	}
	
	public void click_search_btn() {
		
		searchBtn.click();
//		new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(searchBox)).sendKeys(Keys.chord("dress", Keys.ENTER));
	}
	
}
