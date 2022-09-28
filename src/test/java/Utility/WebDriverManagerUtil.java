package Utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerUtil {
  
    private static final long TIMEOUT = 50;
    private WebDriver driver;
    public WebDriver getDriver() {
		if(driver == null) driver = createDriver();
		return driver;
	}

    private WebDriver createDriver()
    {
        WebDriverManager.edgedriver().setup();

        EdgeOptions options = new EdgeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");

        driver = new EdgeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        driver.manage().window().maximize();
        return driver;
    }

    public void WaitTillPageLoads()
    {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
    }

    public void closeDriver() {
		driver.close();
		driver.quit();
	}
}
