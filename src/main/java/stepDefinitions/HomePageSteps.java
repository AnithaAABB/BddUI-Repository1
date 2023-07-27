package stepDefinitions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import utilities.TestContext;

public class HomePageSteps {

	TestContext testContext;
	HomePage homePage;
	WebDriver driver; 
	
	public HomePageSteps(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		driver = testContext.getDriverManager().getDriver();
	}
	
	@Given("user is on Home Page")
	public void userInHomePage(){
		
		homePage.navigateTo_HomePage();;
	}

	@When("user searches for {string}")
	public void he_search_for(String arg1)  {
		homePage.click_search_btn();
		homePage.waitVisibleElement(homePage.getSearchBox(), 3).sendKeys(Keys.chord(arg1, Keys.ENTER));
	}

}
