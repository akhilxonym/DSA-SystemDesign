package src.test.java.src;

import org.junit.Assert;
import org.junit.Test;

import src.App;

public class AppTest {

    @Test
    public void dummyTest() {
        App app = new App();
        Assert.assertEquals("Hello", app.test());
    }
}