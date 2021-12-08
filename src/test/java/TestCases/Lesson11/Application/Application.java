package TestCases.Lesson11.Application;

import TestCases.Lesson11.Page.CartPage;
import TestCases.Lesson11.Page.MainPage;
import TestCases.Lesson11.Page.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Application {
    private WebDriver driver;

    private CartPage cartPage;
    private MainPage mainPage;
    private ProductPage productPage;

    public Application(){
        driver = new ChromeDriver();
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

    public void removeProductInCart(){
        cartPage.open();
        for (int i=0;i<cartPage.productFromCart.size();i++){
            cartPage.removeButton.click();
            cartPage.waitRemoved(cartPage.productFromCart);
        }
    }
}

