package stepDefinitions;

import io.cucumber.java.en.And;
import pageObjects.CartPage;
import utilities.TestContext;

public class CartPageSteps {
	
	TestContext testContext;
	CartPage cartPage;
	
	public CartPageSteps(TestContext context) {
		testContext = context;
		cartPage = testContext.getPageObjectManager().getCartPage();
	}
	
	@And("user moves to checkout from mini cart")
	public void moves_to_checkout_from_mini_cart(){
		cartPage.clickOn_Cart();
		cartPage.clickOn_ContinueToCheckout();	
		
		
	}

}
