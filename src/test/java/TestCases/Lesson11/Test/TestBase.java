package TestCases.Lesson11.Test;

import TestCases.Lesson11.Application.Application;
import org.junit.Before;

public class TestBase {

    public static ThreadLocal<Application> tlApp = new ThreadLocal<>();
    public Application app;

    @Before
    public void start() {
        if (tlApp.get() != null) {
            app = tlApp.get();
            return;
        }

        app = new Application();
        tlApp.set(app);

//        Runtime.getRuntime().addShutdownHook(
//                new Thread(() -> { app.quit(); app = null; }));
    }
}
