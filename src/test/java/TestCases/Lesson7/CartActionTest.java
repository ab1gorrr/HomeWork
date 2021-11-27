package TestCases.Lesson7;

import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

public class CartActionTest {
    WebDriver driver;
    Faker faker = new Faker();
    @Before
    public void start(){
        driver = new ChromeDriver();
    }
    @Test
    public void cartActionTest(){
        //Инизиализация главной страницы
        driver.get("http://localhost/litecart/en/");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        //Добавление товаров в корзину
        for (int i=0;i<3;i++){
            driver.findElement(By.cssSelector("li.product")).click();
            WebElement cartQuantity = driver.findElement(By.cssSelector("div#cart"));
            if(driver.findElements(By.cssSelector("select[name='options[Size]']")).size()>0){
                List<WebElement> sizeCount = driver.findElements(By.cssSelector("select[name='options[Size]'] option"));
                driver.findElements(By.cssSelector("select[name='options[Size]'] option")).get(faker.number().numberBetween(1, sizeCount.size())).click();
            }
            driver.findElement(By.cssSelector("button[name=add_cart_product]")).click();
            wait.until(ExpectedConditions.not(textToBePresentInElement(cartQuantity,cartQuantity.getText())));
            driver.navigate().back();
        }
        //Удаление товаров из корзины
        driver.findElement(By.cssSelector("div#cart a.link")).click();
        List<WebElement> productCountFromCart = driver.findElements(By.cssSelector("table.dataTable td.item"));
        for (int i=0;i<productCountFromCart.size();i++){
            productCountFromCart = driver.findElements(By.cssSelector("table.dataTable td.item"));
            driver.findElement(By.cssSelector("button[name=remove_cart_item]")).click();
            wait.until(ExpectedConditions.stalenessOf(productCountFromCart.get(0)));
        }
    }

    @After
    public void stop(){
        driver.quit();
    }
}
