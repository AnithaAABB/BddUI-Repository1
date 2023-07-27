package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import configs.PersonalDetails;

public class CheckoutPage extends BasePage {

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#billing_first_name")
	private WebElement txtbx_FirstName;

	@FindBy(css = "#billing_last_name")
	private WebElement txtbx_LastName;

	@FindBy(css = "#billing_email")
	private WebElement txtbx_Email;

	@FindBy(css = "#billing_phone")
	private WebElement txtbx_Phone;

	@FindBy(id = "billing_country")
	private WebElement ddown_country;

	@FindBy(id = "billing_state")
	private WebElement ddown_state;

	@FindBy(css = "#billing_city")
	private WebElement txtbx_City;

	@FindBy(css = "#billing_address_1")
	private WebElement txtbx_Address;

	@FindBy(css = "#billing_postcode")
	private WebElement txtbx_PostCode;

	@FindBy(css = "#ship-to-different-address-checkbox")
	private WebElement chkbx_ShipToDifferetAddress;

	@FindAll(@FindBy(css = "ul.wc_payment_methods li"))
	private List<WebElement> paymentMethod_List;

	@FindBy(id = "terms")
	private WebElement chkbx_AcceptTermsAndCondition;

	@FindBy(css = "#place_order")
	private WebElement btn_PlaceOrder;

	public void enterFirstName(String firstName) {
		txtbx_FirstName.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		txtbx_LastName.sendKeys(lastName);
	}
	
	public void enterStreetAddress(String address) {
		txtbx_Address.sendKeys(address);
	}
	
	public void enterCity(String city) {
		txtbx_City.sendKeys(city);
	}
	
	public void enterPostCode(String postCode) {
		txtbx_PostCode.sendKeys(postCode);
	}
	
	public void enterPhone(String phone) {
		txtbx_Phone.sendKeys(phone);
	}
	
	public void enterEmail(String email) {
		txtbx_Email.sendKeys(email);
	}
	
	public WebElement getDdownCountry() {
		return ddown_country;
	}
	
	public WebElement getDdownState() {
		return ddown_state;
	}
	
	public WebElement getTxtBoxAddress() {
		return txtbx_Address;
	}

	public void check_TermsAndCondition(boolean value) throws InterruptedException {
		if (value) {
			Thread.sleep(3000);
			chkbx_AcceptTermsAndCondition.click();
		}
	}

	public void clickOn_PlaceOrder() {
		btn_PlaceOrder.submit();
	}

	public void check_ShipToDifferentAddress(boolean value) {
		if (!value)
			chkbx_ShipToDifferetAddress.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
	}

	public void select_PaymentMethod(String paymentMethod) {
		if (paymentMethod.equals("CheckPayment")) {
			paymentMethod_List.get(0).click();
		} else if (paymentMethod.equals("Cash")) {
			paymentMethod_List.get(1).click();
		} else {
			new Exception("Payment Method not recognised : " + paymentMethod);
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}

	}

//	public void select_Country(String countryName) {
//		drpdwn_CountryDropDownArrow.click();
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//		}
//
//		for (WebElement country : country_List) {
//			if (country.getText().equals(countryName)) {
//				country.click();
//				try {
//					Thread.sleep(3000);
//				} catch (InterruptedException e) {
//				}
//				break;
//			}
//		}
//	}
//
//	public void select_County(String countyName) {
//		drpdwn_CountyDropDownArrow.click();
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//		}
//
//		for (WebElement county : country_List) {
//			if (county.getText().equals(countyName)) {
//				county.click();
//				try {
//					Thread.sleep(3000);
//				} catch (InterruptedException e) {
//				}
//				break;
//			}
//		}
//	}

}
