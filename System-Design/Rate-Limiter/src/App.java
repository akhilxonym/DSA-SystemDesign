package src;

public class App {
    public static void main(String[] args) throws Exception {
        RateLimiterStrategy fixedWindowRLStrategy = new FixedWindowRateLimiter(5, 10);
        RateLimiter rateLimiter = new RateLimiter(fixedWindowRLStrategy);

        for (int i = 0; i < 10; i++) {
            if (rateLimiter.allowRequest("user101")) {
                System.out.println("Request " + (i + 1) + " allowed");
            } else {
                System.out.println("Request " + (i + 1) + " not allowed");
            }
        }
    }

    public String test() {
        return "Hello";
    }
}
