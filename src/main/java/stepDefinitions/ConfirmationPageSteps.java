package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import enums.Context;
import io.cucumber.java.en.And;
import pageObjects.ConfirmationPage;
import utilities.TestContext;

public class ConfirmationPageSteps {

	TestContext testContext;
	ConfirmationPage confirmationPage;
	WebDriver driver;

	public ConfirmationPageSteps(TestContext context) {
		testContext = context;
		confirmationPage = testContext.getPageObjectManager().getConfirmationPage();
		driver = testContext.getDriverManager().getDriver();
	}
	
	@And("take screenshot of order")
	public void takeScreenshot_ofOrder() {
		confirmationPage.scrollToElement(confirmationPage.getOrderContainer());
		confirmationPage.takeScreenshot();
	}
	
	@And("verify the order details")
	public void verify_the_order_details(){
		confirmationPage.waitVisibleElement(confirmationPage.getOrderContainer(), 5);
		
		String productName = (String)testContext.scenarioContext.getContext(Context.PRODUCT_NAME);
		Assert.assertTrue(confirmationPage.getProductNames().stream().filter(x -> x.contains(productName.toLowerCase())).findFirst().get().length()>0);		
	
		String productColor = (String)testContext.scenarioContext.getContext(Context.PRODUCT_COLOR);
		Assert.assertEquals(confirmationPage.getProductColor(), productColor);
		
		String productSize = (String)testContext.scenarioContext.getContext(Context.PRODUCT_SIZE);
		Assert.assertEquals(confirmationPage.getProductSize(), productSize);
	}
	
}
