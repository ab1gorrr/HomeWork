package ru.deliveryClub;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class FirstTest extends WebDriverSettings {

    @Test
    public void firstTest() {
        driver.get("https://www.delivery-club.ru/");
        String title= driver.getTitle();
        Assert.assertTrue(title.equals("Delivery Club — Доставка еды и продуктов"));
    }

    @Test
    public void firstTest2() {
        driver.get("https://www.delivery-club.ru/");

    }

    @Test
    public void searchTest() {
        driver.get("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Image");
        driver.findElement(By.xpath("//div[3]/center/input")).click();
        WebElement searchResult = driver.findElement(By.xpath("//div[@id='rso']/div/div/div[2]/g-section-with-header/div/title-with-lhs-icon/a/div[3]/h3"));
        Assert.assertTrue(searchResult.getText().equals("Картинки по запросу Image"));
    }
}
