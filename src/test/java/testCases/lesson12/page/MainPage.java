package testCases.lesson12.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage extends Page {
    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open(){
        driver.get("http://localhost/litecart/en/");
    }

    @FindBy(css = "li.product")
    public WebElement firstProduct;

    @FindBy(css = "div#cart .quantity")
    public WebElement cartStatus;

}
