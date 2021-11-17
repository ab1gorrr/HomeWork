package TestCases.Lesson4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        System.out.println(element);
        for (int i = 0; i < element.size(); i++) {
            Assert.assertFalse(element.get(i).findElement(By.cssSelector(".sticker")).getText().equals(null));
        }
    }
    @After
    public void close(){
        driver.quit();
    }
}

