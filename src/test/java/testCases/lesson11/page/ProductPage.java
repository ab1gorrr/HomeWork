package testCases.lesson11.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

public class ProductPage extends Page{
    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div#cart")
    public WebElement cartQuantity;

    public void waitCartUpdate(WebElement cartQuantity){
        wait.until(ExpectedConditions.not(textToBePresentInElement(cartQuantity,cartQuantity.getText())));
    }

    @FindBy(css = "select[name='options[Size]']")
    public List<WebElement> sizeSelector;

    @FindBy(css = "select[name='options[Size]'] option")
    public List<WebElement> sizeCount;

    @FindBy(css = "button[name=add_cart_product]")
    public WebElement addButton;
}
