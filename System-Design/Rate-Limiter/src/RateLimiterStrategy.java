package src;

public interface RateLimiterStrategy {
    boolean allowRequest(String userId);
}
