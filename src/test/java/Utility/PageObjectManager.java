package Utility;
import org.openqa.selenium.WebDriver;
import Pages.HomePage;
import Pages.ProductDetailPage;
import Pages.ProductListingPage;

public class PageObjectManager {

    WebDriver driver;

    private HomePage homePage;
    private ProductListingPage productListingPage;
    private ProductDetailPage productDetailPage;

    public PageObjectManager(WebDriver driver)
    {
        this.driver = driver;
    }

    public HomePage getHomePage(){
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}

    public ProductListingPage getProductListingPage(){
		return (productListingPage == null) ? productListingPage = new ProductListingPage(driver) : productListingPage;
	}

    public ProductDetailPage getProductDetailPage(){
		return (productDetailPage == null) ? productDetailPage = new ProductDetailPage(driver) : productDetailPage;
	}
}
