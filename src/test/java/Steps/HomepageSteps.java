package Steps;

import Pages.HomePage;
import Utility.TestContext;
import io.cucumber.java.en.*;

public class HomepageSteps {
    TestContext testContext;
	HomePage homePage; 
  
    public HomepageSteps(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
	}
  
    @Given("^I am on the home page of site (.*)$")
    public void NavigateToHomePage(String url)
    {
        homePage.GoToHomePage(url);
    }

    @Given("^I search for the (.*)$")
    public void SearchForProducts(String product) throws InterruptedException
    {
         homePage.SearchProducts(product);
    }
}
