package TestCases.Lesson11.Test;
import TestCases.Lesson11.Application.Application;
import org.junit.Before;
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
