package testCases.lesson11.application;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import testCases.lesson11.page.CartPage;
import testCases.lesson11.page.MainPage;
import testCases.lesson11.page.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Application {
    private WebDriver driver;
    private List<WebElement> productFromCart;
    private CartPage cartPage;
    private MainPage mainPage;
    private ProductPage productPage;

    public Application(){
        driver = new FirefoxDriver();
        cartPage = new CartPage(driver);
        mainPage = new MainPage(driver);
        productPage = new ProductPage(driver);
    }

    public void quit(){
        driver.quit();
    }

    public void pageBack(){
        driver.navigate().back();
    }

    public void addProductInCart(){
        mainPage.open();
        for (int i=0;i<3;i++) {
            mainPage.firstProduct.click();
            if(productPage.sizeSelector.size()>0){
                productPage.sizeCount.get(1).click();
            }
            productPage.addButton.click();
            productPage.waitCartUpdate(productPage.cartQuantity);
            pageBack();
        }
    }

    public void removeAllProductInCart(){
        cartPage.open();
        int productCountInCart = cartPage.cartSize();
        for (int i=0;i<productCountInCart;i++){
            productFromCart = cartPage.countProductFromCart();
            cartPage.removeButton.click();
            cartPage.waitRemoved(productFromCart);
        }
    }
}

