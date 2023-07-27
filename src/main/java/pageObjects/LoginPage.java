package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "username")
    private  WebElement loginUsername;

	@FindBy(id = "password")
	private	WebElement loginPassword;

	@FindBy(xpath = "//button[text()='Log in']")
	private	WebElement loginBtn;

	@FindBy(id = "reg_username")
	private	WebElement regUsername;

	@FindBy(id = "reg_email")
	private	WebElement regEmail;

	@FindBy(id = "reg_password")
	private 	WebElement regPassword;

	@FindBy(xpath = "//button[text()='Register']")
	WebElement regBtn;

	public void Register_Action(String uName, String email, String pwd) {
		regUsername.sendKeys(uName);
		regEmail.sendKeys(email);
		regPassword.sendKeys(pwd);
		object_Click(loginBtn);
	}

	public void LogIn_Action(String uName, String pwd) {
		loginUsername.sendKeys(uName);
		loginPassword.sendKeys(pwd);
		object_Click(loginBtn);
	}
}
