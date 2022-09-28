package Pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utility.TestContext;

public class ProductListingPage {
    
    WebDriver driver;
    TestContext testContext;
    public ProductListingPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//*[@id='brandsRefinements']/ul/li[8]/span/div/a/span")
    private WebElement seeMoreInBrands;

    @FindBy(how = How.XPATH, using = "//*[@id='p_89/Titan']/span/a/span")
    private WebElement brand;
    @FindBy(how = How.XPATH, using = "//*[@id='p_n_feature_seven_browse-bin/1480900031']/span/a/span")
    private WebElement displaytype;
    @FindBy(how = How.XPATH, using = "//*[@id='p_n_material_browse/1480907031']/span/a/span")
    private WebElement bandmaterial;
    @FindBy(how = How.XPATH, using = "//*[@id='p_n_pct-off-with-tax/2665400031']/span/a/span")
    private WebElement discountper;
    @FindBy(how = How.XPATH, using = "//*[@id='search']/div[1]/div[1]/div/span[3]/div[2]")
    private WebElement resultGrid;
    @FindAll(@FindBy(how = How.XPATH, using = "//*[contains(@id,'search')]/div[1]/div[1]/div/span[3]/div[2]/div[contains(@data-component-type,'s-search-result')][contains(@data-cel-widget,'search_result_')]"))
    private List<WebElement> productList;

    public void ApplyFilter(String display,String brandName,String material,String discount)
    {
        displaytype.click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        seeMoreInBrands.click();
        brand.click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        bandmaterial.click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        discountper.click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
    }

    public List<WebElement> GetElementByIndex(int prodnum1,int prodnum2,int prodnum3)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(resultGrid));
        List<WebElement> choosenProduct = Arrays.asList(productList.get(prodnum1-1), productList.get(prodnum2-1), productList.get(prodnum3-1));
        return choosenProduct;
    }
}
