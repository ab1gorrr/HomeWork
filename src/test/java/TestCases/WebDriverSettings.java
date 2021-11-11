package TestCases;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class WebDriverSettings {
    public ChromeDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webDriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();

    }
    @After
    public void close() {
        driver.quit();
    }
}
