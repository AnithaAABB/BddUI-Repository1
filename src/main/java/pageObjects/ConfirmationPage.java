package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends BasePage{

	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "order")
	private WebElement orderNumber;
	
	@FindAll(@FindBy(css = ".order_item"))
	private List<WebElement> prd_List;
	
	@FindBy(className = "entry-content")
	private WebElement orderContainer;
	
	@FindBy(xpath = "//li/strong[text()='Color:']/following-sibling::p")
	private WebElement productColor;
	
	@FindBy(xpath = "//li/strong[text()='Size:']/following-sibling::p")
	private WebElement productSize;
	
	public WebElement getOrderContainer() {
		return orderContainer;
	}
	
	public List<String> getProductNames() {
		List<String> productNames = new ArrayList<>();
		for(WebElement element : prd_List) {
			productNames.add(element.findElement(By.cssSelector(".product-name")).getText());
		}
		return productNames;
	}
	
	public String getProductColor() {
		return productColor.getText();
	}
	
	public String getProductSize() {
		return productSize.getText();
	}
	
}
