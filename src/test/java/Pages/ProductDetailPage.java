package Pages;

import Utility.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import java.util.*;

public class ProductDetailPage {

    TestContext testContext;
    ProductDetailPage PDP;
    WebDriver driver;
    Map<String,Boolean> IsFreeDeliveryAndDeliveredByAmazon = new Hashtable<>();
    public ProductDetailPage(WebDriver driver)
    {
        this.driver=driver;
      PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.XPATH,using = "//*[@id='technicalSpecifications_section_1']/tbody")
    private WebElement specificationTableRows;
    @FindBy(how = How.XPATH,using = "//*[@id='FREE_DELIVERY']")
    private WebElement freeDelivery;
    @FindBy(how = How.XPATH,using = "//*[@id='AMAZON_DELIVERED']")
    private WebElement deliveredByAmazon;

    SoftAssert softAssert = new SoftAssert();

    public void ValidateProductMatchSearchAndFilterCriteria(String display,String brand,String material)
    {
        List<WebElement> rows=specificationTableRows.findElements(By.tagName("tr"));

        for(int rnum=0;rnum<rows.size();rnum++)
        {
            Map<String,String> properties = new HashMap<String,String>();
            List<WebElement> columns=rows.get(rnum).findElements(By.tagName("th"));
            //System.out.println("Number of columns:"+columns.size());
            List<WebElement> value=rows.get(rnum).findElements(By.tagName("td"));
            for(int cnum=0;cnum<columns.size();cnum++)
            {
                if (columns.get(cnum).getText().contains("Display Type")) {
                    properties.put(columns.get(cnum).getText(), value.get(cnum).getText());
                    softAssert.assertEquals(value.get(cnum).getText(), display);
                    System.out.println(value.get(cnum).getText());
                }
                if (columns.get(cnum).getText().contains("Brand")) {
                    properties.put(columns.get(cnum).getText(), value.get(cnum).getText());
                    softAssert.assertEquals(value.get(cnum).getText(), brand);
                    System.out.println(value.get(cnum).getText());
                }
                if (columns.get(cnum).getText().contains("Band Material")) {
                    properties.put(columns.get(cnum).getText(), value.get(cnum).getText());
                    softAssert.assertEquals(value.get(cnum).getText(),material);
                    System.out.println(value.get(cnum).getText());
                }
            }
        }
    }

    public boolean ValidateFreeDelivery()
    {
       return freeDelivery.isDisplayed();
    }

    public boolean ValidateAmazonDelivery()
    {
        return deliveredByAmazon.isDisplayed();
    }

    public void SaveProductDetails()
    {
        if (ValidateFreeDelivery())
            IsFreeDeliveryAndDeliveredByAmazon.put("Free Delivery",true);
        if(ValidateAmazonDelivery())
            IsFreeDeliveryAndDeliveredByAmazon.put("Amazon Fulfilled",true);
    }

    public Map<String, Boolean> GetProductDetails()
    {
        System.out.println(IsFreeDeliveryAndDeliveredByAmazon);
        return IsFreeDeliveryAndDeliveredByAmazon;
    }
    public void ReturnToSearchPage()
    {
        ArrayList<String> pdpPage = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(pdpPage.get(0));
    }
    public void  NavigateToProductDetailPage()
    {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
        ArrayList<String> pdpPage = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(pdpPage.get(1));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
    }
}
