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

public class AdminMenuTest {

    public WebDriver driver;


    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.get(" http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @Test
    public void menuLinkTest(){
       List<WebElement> element = driver.findElements(By.xpath("//*[@id=\"app-\"]"));
      for(int i=0;i<element.size();i++){
          element = driver.findElements(By.xpath("//*[@id=\"app-\"]"));
          element.get(i).click();
          Assert.assertFalse(driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText().equals(null));
      driver.navigate().back();
      }
    }

    @After
    public void close(){
        driver.quit();
    }
}
