package src.test.java.src;

import org.junit.Assert;
import org.junit.Test;

import src.App;
import src.FixedWindowRateLimiter;
import src.RateLimiter;
import src.RateLimiterStrategy;
import src.constants.RateLimiterContants;

public class AppTest {

    @Test
    public void testForSingleUser() {
        RateLimiterStrategy fixedWindowRLStrategy = new FixedWindowRateLimiter(RateLimiterContants.MAX_REQUESTS,
                RateLimiterContants.WINDOW_SIZE);
        RateLimiter rateLimiter = new RateLimiter(fixedWindowRLStrategy);
        for (int i = 0; i < 10; i++) {
            if (i < 5)
                Assert.assertEquals(true, rateLimiter.allowRequest("user101"));
            else
                Assert.assertEquals(false, rateLimiter.allowRequest("user101"));

        }

    }
}