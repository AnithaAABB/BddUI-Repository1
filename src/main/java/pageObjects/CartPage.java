package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CSS, using = ".cart-button")
	private WebElement btn_Cart;

	@FindBy(how = How.CSS, using = ".checkout-button.alt")
	private WebElement btn_ContinueToCheckout;

	public void clickOn_Cart() {
		object_Click(btn_Cart);
	}

	public void clickOn_ContinueToCheckout() {

		try {
			object_Click(btn_ContinueToCheckout);
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
	}

}
