package testCases.lesson11.test;
import testCases.lesson11.application.Application;
import org.junit.Test;

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
