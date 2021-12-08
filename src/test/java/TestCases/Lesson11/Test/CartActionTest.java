package TestCases.Lesson11.Test;
import org.junit.Test;

public class CartActionTest extends TestBase{

    @Test
    public void cartActionTest() {
        app.addProductInCart();
        app.removeProductInCart();
    }


}
