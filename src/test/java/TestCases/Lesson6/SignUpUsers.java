package TestCases.Lesson6;

import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SignUpUsers {
    WebDriver driver;
    Faker faker = new Faker();
    @Before
    public void start(){
        driver = new ChromeDriver();
        driver.navigate().to("http://localhost/litecart/en/create_account");
    }

    @Test
    public void signUpUser(){
        String firstName = faker.name().firstName();
        String email = firstName+"@test.test";
        String password = faker.name().lastName();
        driver.findElement(By.cssSelector("input[name=firstname]")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input[name=lastname]")).sendKeys(faker.name().lastName());
        driver.findElement(By.cssSelector("input[name=address1]")).sendKeys(faker.address().streetName());
        driver.findElement(By.cssSelector("input[name=postcode]")).sendKeys(faker.address().zipCode());
        driver.findElement(By.cssSelector("input[name=city]")).sendKeys(faker.address().city());
        driver.findElement(By.cssSelector("span.select2")).click();
        driver.findElement(By.cssSelector("input.select2-search__field")).sendKeys("United States" + Keys.ENTER);
        driver.findElement(By.cssSelector("select[name=zone_code]")).click();
        List<WebElement> codeZoneList = driver.findElements(By.cssSelector("select[name=zone_code] > option"));
        codeZoneList.get(faker.number().numberBetween(0,codeZoneList.size())).click();
        driver.findElement(By.cssSelector("input[name=email]")).sendKeys(email);
        driver.findElement(By.cssSelector("input[name=phone]")).sendKeys(Keys.HOME + faker.phoneNumber().cellPhone());
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys(password);
        driver.findElement(By.cssSelector("input[name=confirmed_password]")).sendKeys(password);
        driver.findElement(By.cssSelector("button[name=create_account]")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#navigation li:nth-child(4) > a")).click();
        driver.findElement(By.cssSelector("input[name=email]")).sendKeys(email);
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys(password);
        driver.findElement(By.cssSelector("button[name=login]")).click();

    }


    @After
    public void stop(){
        driver.quit();
    }
}
