package TestCases.Lesson11.Page;

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

    @FindBy(css = "table.dataTable td.item")
    public List<WebElement> productFromCart;


    @FindBy(css = "button[name=remove_cart_item]")
    public WebElement removeButton;
}
