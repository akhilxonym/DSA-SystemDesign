package src;

public class RateLimiter {
    private RateLimiterStrategy strategy;

    public RateLimiter(RateLimiterStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean allowRequest(String userId) {
        return strategy.allowRequest(userId);
    }
}
