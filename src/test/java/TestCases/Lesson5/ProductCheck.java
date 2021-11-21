package TestCases.Lesson5;

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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductCheck {
    WebDriver driver;
    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.get("http://localhost/litecart/en/");
    }
    @Test
    public void productVerify() {
        List<WebElement> productList = driver.findElements(By.cssSelector("div#box-campaigns ul li.product"));
        double regularPrice;
        double campaignPrice;
        if (productList.size()>0){
            String[] productLink = new String[productList.size()];
            String[] productName = new String[productList.size()];
            String[] productCostRegular = new String[productList.size()];
            String[] productCostCampaign = new String[productList.size()];
            for (int i=0;i<productList.size();i++){
                productLink[i] = productList.get(i).findElement(By.cssSelector("a.link")).getAttribute("href");
                productName[i] = productList.get(i).findElement(By.cssSelector("div.name")).getText();
                productCostRegular[i] = productList.get(i).findElement(By.cssSelector("s.regular-price")).getText();
                productCostCampaign[i] = productList.get(i).findElement(By.cssSelector("strong.campaign-price")).getText();
                Assert.assertTrue(grayColorCheck(productList.get(i).findElement(By.cssSelector("s.regular-price")).getCssValue("color").replaceAll("rgba", "")));
                Assert.assertTrue(redColorCheck(productList.get(i).findElement(By.cssSelector("strong.campaign-price")).getCssValue("color").replaceAll("rgba", "")));
                regularPrice = Double.parseDouble(productList.get(i).findElement(By.cssSelector("s.regular-price")).getCssValue("font-size").replaceAll("px",""));
                campaignPrice = Double.parseDouble(productList.get(i).findElement(By.cssSelector("strong.campaign-price")).getCssValue("font-size").replaceAll("px",""));
                Assert.assertTrue(regularPrice<campaignPrice);
                Assert.assertEquals(productList.get(i).findElement(By.cssSelector("s.regular-price")).getCssValue("text-decoration-line"),"line-through");
                Assert.assertEquals(productList.get(i).findElement(By.cssSelector("strong.campaign-price")).getCssValue("font-weight"),"700");
            }
            for (int y=0;y<productList.size();y++){
                driver.navigate().to(productLink[y]);
                Assert.assertEquals(driver.findElement(By.cssSelector("s.regular-price")).getCssValue("text-decoration-line"),"line-through");
                Assert.assertEquals(driver.findElement(By.cssSelector("strong.campaign-price")).getCssValue("font-weight"),"700");
                Assert.assertEquals(productCostRegular[y],driver.findElement(By.cssSelector("s.regular-price")).getText().trim());
                Assert.assertEquals(productName[y],driver.findElement(By.cssSelector("div#box-product h1")).getText());
                Assert.assertEquals(productCostCampaign[y],driver.findElement(By.cssSelector("strong.campaign-price")).getText());
                regularPrice = Double.parseDouble(driver.findElement(By.cssSelector("s.regular-price")).getCssValue("font-size").replaceAll("px",""));
                campaignPrice = Double.parseDouble(driver.findElement(By.cssSelector("strong.campaign-price")).getCssValue("font-size").replaceAll("px",""));
                Assert.assertTrue(regularPrice<campaignPrice);

            }
        }

    }

    public List<Integer> colorToArray(String rgbaValue){
        Matcher m = Pattern.compile("\\d+").matcher(rgbaValue);
        List<Integer> rgbaValueArray = new ArrayList<>();
        while(m.find()) {
            rgbaValueArray.add(Integer.parseInt(m.group()));
        }
        return rgbaValueArray;
    }

    public boolean redColorCheck(String rgbaValue) {
        List<Integer> rgbaValueArray = colorToArray(rgbaValue);
        int gValue = rgbaValueArray.get(1);
        int bValue = rgbaValueArray.get(2);
        return gValue == bValue && bValue == 0;
    }
    public boolean grayColorCheck(String rgbaValue) {
        List<Integer> rgbaValueArray = colorToArray(rgbaValue);
        colorToArray(rgbaValue);
        int rValue = rgbaValueArray.get(0);
        int gValue = rgbaValueArray.get(1);
        int bValue = rgbaValueArray.get(2);
        return rValue == gValue && gValue == bValue;
    }

    @After
    public void stop() {
        driver.quit();
    }
}
