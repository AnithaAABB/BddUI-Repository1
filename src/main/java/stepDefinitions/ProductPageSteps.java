package stepDefinitions;

import enums.Context;
import io.cucumber.java.en.And;
import pageObjects.ProductPage;
import utilities.TestContext;

public class ProductPageSteps {

	TestContext testContext;
	ProductPage productPage;

	public ProductPageSteps(TestContext context) {
		testContext = context;
		productPage = testContext.getPageObjectManager().getProductPage();
	}

	@And("user chooses to buy the item {int} with color as {string} and size as {string}")
	public void choose_to_buy_the__item(int arg1, String arg2, String arg3) {
		try {
			String productName = productPage.getProductName(arg1 - 1);
			testContext.scenarioContext.setContext(Context.PRODUCT_NAME, productName);
			productPage.select_Product(arg1 - 1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		testContext.scenarioContext.setContext(Context.PRODUCT_COLOR, arg2);
		testContext.scenarioContext.setContext(Context.PRODUCT_SIZE, arg3);
		productPage.selectOptionByText(productPage.getDdownColor(), arg2);
		productPage.selectOptionByText(productPage.getDdownSize(), arg3);
		productPage.clickOn_AddToCart();
	}
}
