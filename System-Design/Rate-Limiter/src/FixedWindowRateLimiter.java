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
        long currTime = System.currentTimeMillis() / 1000;
        long windowStartTs = (currTime / windowSize) * windowSize;

        UserRequestInfo userRequestInfo = userRequests.getOrDefault(userId, new UserRequestInfo(windowStartTs, 0));

        if (userRequestInfo.getwindowStartTs() != windowStartTs) {
            userRequestInfo.setwindowStartTs(windowStartTs);
            userRequestInfo.setRequestCount(0);
        }

        if (userRequestInfo.getRequestCount() < maxRequests) {
            userRequestInfo.setRequestCount(userRequestInfo.getRequestCount() + 1);
            userRequests.put(userId, userRequestInfo);
            return true;
        }
        return false;
    }

}
