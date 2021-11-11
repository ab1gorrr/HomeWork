package TestCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class litecartLogin extends WebDriverSettings{

    @Test
    public void testLogin(){
        driver.get(" http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='notices']/div[2]")).getText().equals("You are now logged in as admin"));
    }

}
