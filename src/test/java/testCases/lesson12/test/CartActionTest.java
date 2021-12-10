package testCases.lesson12.test;
import org.junit.Test;
import testCases.lesson12.application.Application;

public class CartActionTest{
    public Application app;

    public CartActionTest(){
        app = new Application();

    }

    @Test
    public void cartActionTest() {
        app.addProductInCart();
        app.removeAllProductInCart();
        app.quit();
    }


}
