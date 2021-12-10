package testCases.lesson12.cucumber;

import io.cucumber.java8.En;
import testCases.lesson12.application.Application;

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
