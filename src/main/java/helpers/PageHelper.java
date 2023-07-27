package helpers;

import configs.PersonalDetails;
import pageObjects.CheckoutPage;

public class PageHelper {
	
	CheckoutPage checkoutPage;
	
	public PageHelper(CheckoutPage checkoutPage) {
		this.checkoutPage = checkoutPage;
	}
	
	public void fill_PersonalDetails(PersonalDetails personalDetails) {
		checkoutPage.enterFirstName(personalDetails.firstName);
		checkoutPage.enterLastName(personalDetails.lastName);
		checkoutPage.selectOptionByText(checkoutPage.getDdownCountry(), personalDetails.address.country);
		checkoutPage.enterStreetAddress(personalDetails.address.streetAddress);
		checkoutPage.enterCity(personalDetails.address.city);
		checkoutPage.selectOptionByText(checkoutPage.getDdownState(), personalDetails.address.state);
		checkoutPage.enterPostCode(personalDetails.address.postCode);
		checkoutPage.enterPhone(personalDetails.phoneNumber.mob);
		checkoutPage.enterEmail(personalDetails.emailAddress);
	}
	
	public void acceptTnC(boolean value) throws InterruptedException{
		checkoutPage.scrollToElement(checkoutPage.getTxtBoxAddress());
		checkoutPage.check_TermsAndCondition(value);
	}
}
