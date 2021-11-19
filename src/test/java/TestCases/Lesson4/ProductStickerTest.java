package TestCases.Lesson4;

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
        for (int i = 0; i < element.size(); i++) {
            Assert.assertTrue(element.get(i).findElements(By.cssSelector(".sticker")).size()==1);
        }
    }
    @After
    public void close(){
        driver.quit();
    }
}

