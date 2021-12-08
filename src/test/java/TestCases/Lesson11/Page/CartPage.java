package TestCases.Lesson11.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    }

    @FindBy(css = "table.dataTable td.item")
    public List<WebElement> productFromCart;

    public List<WebElement> countProductFromCart;

    @FindBy(css = "button[name=remove_cart_item]")
    public WebElement removeButton;
}