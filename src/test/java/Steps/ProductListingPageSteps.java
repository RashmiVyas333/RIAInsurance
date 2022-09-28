package Steps;

import Pages.ProductDetailPage;
import Pages.ProductListingPage;
import Utility.Context;
import Utility.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

public class ProductListingPageSteps {
    TestContext testContext;
    ProductListingPage PLP;

    public ProductListingPageSteps(TestContext context)
    {
          testContext = context;
          PLP =testContext.getPageObjectManager().getProductListingPage();
    }
    @Given("I apply following filter")
    public void ApplyFollowingFilter(DataTable dataTable) {

       List<Map<String,String>> filters = dataTable.asMaps();
       String display = filters.get(0).get("Display");
       testContext.getScenarioContext().setContext(Context.DisplayType,display);
       String brand = filters.get(0).get("Brand");
       testContext.getScenarioContext().setContext(Context.ProductBrand,brand);
       String material = filters.get(0).get("Material");
       testContext.getScenarioContext().setContext(Context.Material,material);
       String discount = filters.get(0).get("Discount");
       testContext.getScenarioContext().setContext(Context.Discount,discount);
       PLP.ApplyFilter(display,brand,material,discount);
    }
    
    @When("^I get the product number (.*),(.*) and (.*) from the search$")
    public void GetProductsInPage(String i, String j, String k) {
        List<WebElement> prodList= PLP.GetElementByIndex( Integer.parseInt(i), Integer.parseInt(j), Integer.parseInt(k));
        testContext.getScenarioContext().setContext(Context.ProductList, prodList);
    }
}
