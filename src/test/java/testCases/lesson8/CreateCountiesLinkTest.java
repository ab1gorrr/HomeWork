package testCases.lesson8;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;

public class CreateCountiesLinkTest {
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
    public void countyListAlphabet() {
        driver.navigate().to("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.cssSelector("td#content > div > a")).click();
        String titleMainWindow = driver.getTitle();
        String mainWindow = driver.getWindowHandle();
        List<WebElement> linkList = driver.findElements(By.cssSelector("i.fa-external-link"));
        for (WebElement webElement : linkList) {
            webElement.click();
            switchWindow(mainWindow);
            Assert.assertNotEquals(titleMainWindow, driver.getTitle());
            driver.close();
            driver.switchTo().window(mainWindow);
        }
    }

    public void switchWindow(String mainWindow){
        ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
        newTab.remove(mainWindow);
        driver.switchTo().window(newTab.get(0));
    }
    @After
    public void stop() {
        driver.quit();
    }
}
