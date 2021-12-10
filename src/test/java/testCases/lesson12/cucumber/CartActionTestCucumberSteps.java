package testCases.lesson12.cucumber;

import io.cucumber.java8.En;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import testCases.lesson12.application.Application;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty",features = "src\\test\\resources\\cucumber.lesson12.cartAction")
public class CartActionTestCucumberSteps implements En {
    private Application app = new Application();
    public CartActionTestCucumberSteps() {
        Given("^Open main page shop$", () -> app.openManePageShop());
        And("^Add the first product from the main page three times$", () -> app.addProductInCart());
        Then("^Open cart page$", () -> app.openCartPage());
        And("^Removed all product in cart$", () -> app.removeAllProductInCart());
        And("^Close this browser$", () -> app.quit());


    }
}
