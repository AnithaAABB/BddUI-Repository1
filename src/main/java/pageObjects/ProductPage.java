package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage{

	WebDriver driver;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindAll(@FindBy(how = How.CSS, using = ".noo-product-inner"))
	private List<WebElement> prd_List;

	@FindBy(how = How.ID, using = "pa_color")
	private WebElement ddown_color;

	@FindBy(how = How.ID, using = "pa_size")
	private WebElement ddown_size;

	@FindBy(how = How.CSS, using = "button.single_add_to_cart_button")
	private WebElement btn_AddToCart;

	
	public WebElement getDdownColor() {
		return ddown_color;
	}
	
	public WebElement getDdownSize() {
		return ddown_size;
	}
	
	public void select_Product(int productNumber) {
		prd_List.get(productNumber).click();
	}

	public String getProductName(int productNumber) {
		return prd_List.get(productNumber).findElement(By.cssSelector("h3")).getText();
	}

	public void clickOn_AddToCart() {
		btn_AddToCart.click();
	}
}
