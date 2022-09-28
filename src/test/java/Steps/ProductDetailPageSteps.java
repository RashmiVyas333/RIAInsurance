package Steps;

import Pages.ProductDetailPage;
import Pages.ProductListingPage;
import Utility.Context;
import Utility.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ProductDetailPageSteps {
    TestContext testContext;
    ProductDetailPage PDP;
    ProductListingPage PLP;
    SoftAssert softAssert = new SoftAssert();
    public ProductDetailPageSteps(TestContext context)
    {
          testContext = context;
          PDP =testContext.getPageObjectManager().getProductDetailPage();
    }
    
    @Then("^I validate that the products match the search and filter criteria$")
    public void ValidateProductsMatchSearchAndFilterCriteria() {
        List<WebElement> prod = (List<WebElement>) testContext.getScenarioContext().getContext(Context.ProductList);
        for(WebElement p:prod)
        {
            p.click();
            PDP.NavigateToProductDetailPage();
            testContext.getWebDriverManagerUtil().WaitTillPageLoads();
            String display = (String) testContext.getScenarioContext().getContext(Context.DisplayType);
            String brand = (String) testContext.getScenarioContext().getContext(Context.ProductBrand);
            String material = (String) testContext.getScenarioContext().getContext(Context.Material);
            PDP.ValidateProductMatchSearchAndFilterCriteria(display,brand,material);
            PDP.SaveProductDetails();
            PDP.ReturnToSearchPage();
        }
    }
    @Then("^I verify that delivery is fulfilled by Amazon$")
    public void VerifyThatDeliveryIsAmazonFulfilled() {
           softAssert.assertTrue(PDP.GetProductDetails().get("Amazon Fulfilled"));
        }

    @And("^I verify that delivery is free$")
    public void VerifyThatDeliveryIsFree() {
           softAssert.assertTrue(PDP.GetProductDetails().get("Free Delivery"));
    }
}
