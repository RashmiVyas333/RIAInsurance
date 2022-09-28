package Pages;

import Utility.PageObjectManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.lang.Thread;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "twotabsearchtextbox")
    private WebElement searchTextField;
    @FindBy(how = How.ID, using = "nav-search-submit-button")
    private WebElement searchButton;

    public void GoToHomePage(String url)
    {
       driver.get(url);
    }

    public void SearchProducts(String product) throws InterruptedException
    {
        searchTextField.sendKeys(product);
        searchButton.click();
        Thread.sleep(10000);
    }

}
