package testCases.lesson12.cucumber;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.cucumber.java8.En;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import testCases.lesson12.application.Application;

public class CartActionTestCucumberSteps implements En {
    private Application app = new Application();
    String productIntoCart;
    public CartActionTestCucumberSteps() {
        Given("^the cart is empty$", () -> {
            app.openManePageShop();
            productIntoCart = app.getCartStatus().getText();
            Assert.assertEquals(Integer.parseInt(productIntoCart),0);
        });
        When("^I add three product into cart$", () -> app.addProductInCart());
        Then("^the cart contains three product$", () -> Assert.assertEquals(app.parseToInt(app.getCartStatus().getText()),3));
        When("^I remove everything from the cart$", () -> {
            app.removeAllProductInCart();
            app.openManePageShop();
            Assert.assertEquals(app.parseToInt(app.getCartStatus().getText()), 0);
            app.quit();
        });


    }
}
