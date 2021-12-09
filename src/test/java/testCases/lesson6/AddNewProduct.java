package testCases.lesson6;

import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Path;

public class AddNewProduct {
    WebDriver driver;
    Faker faker = new Faker();
    @Before
    public void start(){
        driver = new ChromeDriver();
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.navigate().to("http://localhost/litecart/admin/?app=catalog&doc=catalog");
    }

    @Test
    public void addNewProduct(){
        String imgPath = "src/test/resources/pink_duck.jpg";
        String absoluteImgPath = Path.of(imgPath).toAbsolutePath().toString();
        //Раздел General
        driver.findElement(By.cssSelector("div a.button:nth-child(2)")).click();
        driver.findElement(By.cssSelector("td > label:nth-child(3)")).click();
        driver.findElement(By.cssSelector("input[name='name[en]']")).sendKeys("Pink Duck");
        driver.findElement(By.cssSelector("input[name='code']")).sendKeys("rd006");
        driver.findElement(By.cssSelector("input[type=file]")).sendKeys(absoluteImgPath);
        //Раздел Information
        driver.findElement(By.cssSelector("ul.index li:nth-child(2)")).click();
        driver.findElement(By.cssSelector("select[name=manufacturer_id]")).click();
        driver.findElement(By.cssSelector("select[name=manufacturer_id] > option:nth-child(2)")).click();
        driver.findElement(By.cssSelector("input[name='short_description[en]']")).sendKeys(faker.lorem().sentence(7));
        driver.findElement(By.cssSelector("div.trumbowyg-editor")).sendKeys(faker.lorem().paragraph(3));
        //Раздел Prices
        driver.findElement(By.cssSelector("ul.index li:nth-child(4)")).click();
        driver.findElement(By.cssSelector("input[name=purchase_price]")).clear();
        driver.findElement(By.cssSelector("input[name=purchase_price]")).sendKeys("10,00");
        driver.findElement(By.cssSelector("input[name='prices[USD]']")).sendKeys("23.0000");
        driver.findElement(By.cssSelector("input[name='prices[EUR]']")).sendKeys("0,0000");
        driver.findElement(By.cssSelector("button[name=save]")).click();
        //Проверка наличия добавленного товара
        Assert.assertEquals(1, driver.findElements(By.xpath("//a[text()='Pink Duck']")).size());
    }

    @After
    public void stop(){
        driver.quit();
    }
}
