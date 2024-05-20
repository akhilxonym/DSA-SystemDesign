package src;

import src.constants.RateLimiterContants;

public class App {
    public static void main(String[] args) throws Exception {
        RateLimiterStrategy fixedWindowRLStrategy = new FixedWindowRateLimiter(RateLimiterContants.MAX_REQUESTS,
                RateLimiterContants.WINDOW_SIZE);
        RateLimiter rateLimiter = new RateLimiter(fixedWindowRLStrategy);

        for (int i = 0; i < 12; i++) {
            if (rateLimiter.allowRequest("user101")) {
                System.out.println("Request " + (i + 1) + " allowed for user101");
            } else {
                System.out.println("Request " + (i + 1) + " not allowed for user101");
            }
            if (i >= 6) {
                if (rateLimiter.allowRequest("user201")) {
                    System.out.println("Request " + (i + 1) + " allowed " + " for user201");
                } else {
                    System.out.println("Request " + (i + 1) + " not allowed for user201");
                }
            }
        }
    }

    public String test() {
        return "Hello";
    }
}
