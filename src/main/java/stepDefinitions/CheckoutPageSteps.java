package stepDefinitions;

import configs.PersonalDetails;
import helpers.PageHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import managers.FileReaderManager;
import pageObjects.CheckoutPage;
import utilities.TestContext;

public class CheckoutPageSteps {

	TestContext testContext;
	CheckoutPage checkoutPage;
	PageHelper pageHelper;

	public CheckoutPageSteps(TestContext context) {
		testContext = context;
		checkoutPage = testContext.getPageObjectManager().getCheckoutPage();
		pageHelper = new PageHelper(checkoutPage);
	}
	
	@And("user enters {string} personal details on checkout page")
	public void enter_personal_details_on_checkout_page(String customerName){
		PersonalDetails personalDetails = FileReaderManager.getInstance().getJsonReader().getCustomerByName(customerName);
		pageHelper.fill_PersonalDetails(personalDetails);
	}
	
	@And("user selects same delivery address")
	public void select_same_delivery_address(){
		checkoutPage.check_ShipToDifferentAddress(false);
	}
	
	@And("user selects payment method as {string}")
	public void select_payment_method_as_payment(String arg1){
		checkoutPage.select_PaymentMethod(arg1);
	}
	
	@And("user accepts terms and conditions")
	public void acceptTerms() throws InterruptedException {
		pageHelper.acceptTnC(true);
	}

	@Then("place the order")
	public void placeOrder() {
		checkoutPage.clickOn_PlaceOrder();		
	}	

}
