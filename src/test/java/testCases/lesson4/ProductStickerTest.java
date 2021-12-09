package testCases.lesson4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;

public class ProductStickerTest {

    public WebDriver driver;


    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.get("http://localhost/litecart/en/");
    }

    @Test
    public void testStickers() {
        List<WebElement> element = driver.findElements(By.cssSelector("li.product"));
        for (WebElement webElement : element) {
            Assert.assertEquals(1, webElement.findElements(By.cssSelector(".sticker")).size());
        }
    }
    @After
    public void close(){
        driver.quit();
    }
}

