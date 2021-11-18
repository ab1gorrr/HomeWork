package TestCases.Lesson4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AdminMenuTest {

    public WebDriver driver;


    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @Test
    public void menuLinkTest(){
        List<WebElement> mainOption = driver.findElements(By.cssSelector("ul#box-apps-menu>li"));
        List<WebElement> sideOption;
        for(int i=0;i<mainOption.size();i++){
            mainOption = driver.findElements(By.cssSelector("ul#box-apps-menu>li"));
            mainOption.get(i).click();
            Assert.assertFalse(driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText().equals(null));
            sideOption = driver.findElements(By.cssSelector("ul.docs>li"));
            if (sideOption !=null && sideOption.size() > 1){
                for (int y=0;y<sideOption.size();y++){
                    sideOption = driver.findElements(By.cssSelector("ul.docs>li"));
                    sideOption.get(y).click();
                    Assert.assertFalse(driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText().equals(null));
                }
            }
            driver.navigate().back();
        }
    }

    @After
    public void close(){
        driver.quit();
    }
}
