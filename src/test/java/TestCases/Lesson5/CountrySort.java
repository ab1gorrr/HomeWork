package TestCases.Lesson5;

import com.beust.jcommander.converters.IntegerConverter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.Array;
import java.util.*;

public class CountrySort {
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
        List<WebElement> nameRowList = driver.findElements(By.cssSelector("tr > td:nth-child(5) > a"));
        Assert.assertTrue(checkSort(nameRowList));
        List<WebElement> countriesWithGeoZone = driver.findElements(By.xpath("//td[6][text()!='0']/../td[5]/a"));
        for (int i=0;i<countriesWithGeoZone.size();i++){
            countriesWithGeoZone = driver.findElements(By.xpath("//td[6][text()!='0']/../td[5]/a"));
            countriesWithGeoZone.get(i).click();
            nameRowList = driver.findElements(By.cssSelector("table.dataTable tr > td:nth-child(3)"));
            int indexOfLastElement = nameRowList.size() -1;
            nameRowList.remove(indexOfLastElement);
            Assert.assertTrue(checkSort(nameRowList));
            driver.navigate().back();
        }

    }

    @Test
    public void geoZoneCountry(){
        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        List<WebElement> countriesGeoZoneList = driver.findElements(By.cssSelector("tr.row > td:nth-child(3) > a"));
        List<WebElement> geoZoneName;
        for (int i=0;i<countriesGeoZoneList.size();i++) {
            countriesGeoZoneList = driver.findElements(By.cssSelector("tr.row > td:nth-child(3) > a"));
            countriesGeoZoneList.get(i).click();
            geoZoneName = driver.findElements(By.cssSelector("table.dataTable td:nth-child(3)"));
            Assert.assertTrue(checkSort(geoZoneName));
            driver.navigate().back();
        }
    }
    public boolean checkSort(List<WebElement> rowNameList){
        List<String> obtainedList = new ArrayList<>();
        for (WebElement we:rowNameList) {
            obtainedList.add(we.getText());
        }
        ArrayList<String> sortedList = new ArrayList<>(obtainedList);
        Collections.sort(sortedList);
        return sortedList.equals(obtainedList);
    }
    @After
    public void stop() {
        driver.quit();
    }
}
