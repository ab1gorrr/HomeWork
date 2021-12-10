package testCases.lesson12.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends Page {

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open(){
        driver.get("http://localhost/litecart/en/checkout");
    }

    public void waitRemoved(List<WebElement> countProductFromCart){
        wait.until(ExpectedConditions.stalenessOf(countProductFromCart.get(0)));
    }

    public List<WebElement> countProductFromCart() {
        return driver.findElements(By.cssSelector("table.dataTable td.item"));
    }

    public int cartSize() {
        return driver.findElements(By.cssSelector("table.dataTable td.item")).size();
    }

    @FindBy(css = "button[name=remove_cart_item]")
    public WebElement removeButton;
}
