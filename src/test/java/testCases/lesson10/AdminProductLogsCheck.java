package testCases.lesson10;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;

import java.util.List;
import java.util.logging.Level;

public class AdminProductLogsCheck {
    WebDriver driver;

    @Before
    public void start() {

        driver = new ChromeDriver();
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @Test
    public void takeProduct() {
        driver.navigate().to("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        List<WebElement> productList = driver.findElements(By.cssSelector("tr.row td:nth-child(3) a[href*=product_id]"));
        for (int i=0;i<productList.size();i++){
            productList = driver.findElements(By.cssSelector("tr.row td:nth-child(3) a[href*=product_id]"));
            productList.get(i).click();
            takeLogs();
            driver.navigate().back();
        }
    }

    public void takeLogs(){
        Assert.assertTrue(driver.manage().logs().get("browser").getAll().isEmpty());
    }

    @After
    public void stop(){
        driver.quit();
    }
}
