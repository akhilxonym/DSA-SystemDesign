package src;

import java.util.HashMap;
import java.util.Map;

import src.model.UserRequestInfo;

public class FixedWindowRateLimiter implements RateLimiterStrategy {
    private final int maxRequests;
    private final int windowSize;
    private final Map<String, UserRequestInfo> userRequests;

    public FixedWindowRateLimiter(int maxRequests, int windowSize) {
        this.maxRequests = maxRequests;
        this.windowSize = windowSize;
        this.userRequests = new HashMap<>();
    }

    @Override
    public synchronized boolean allowRequest(String userId) {

        return false;
    }

}