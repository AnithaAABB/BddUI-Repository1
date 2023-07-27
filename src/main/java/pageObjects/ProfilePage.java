package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends BasePage{

	WebDriver driver;
	
	public ProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Checkout")
	private WebElement checkoutBtn;
	
	@FindBy(xpath = "//*[@id=\"post-8\"]/div/div/div/p[1]/strong[1]")
	private WebElement user;

	@CacheLookup
	@FindBy(linkText = "Logout")
	private WebElement logoutBtn1;

	public void navigate_to_CheckoutPage() {
		checkoutBtn.click();
	}
	
	public void verify_User(String usrNm) {

		if (user.getText().equalsIgnoreCase(usrNm))
			System.out.println("Correct username, ie " + user.getText());

		else
			System.out.println("Incorrect username..." + user.getText());
	}

	public void logout_Action() {
		System.out.println("User logged out");
		logoutBtn1.click();
	}
}
