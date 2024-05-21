package src;

import src.constants.RateLimiterContants;
import src.model.CreditUserRequestInfo;
import src.model.UserRequestInfo;

public class CreditBasedFixedWindowRL extends FixedWindowRateLimiter {

    private final int maxCredits;

    public CreditBasedFixedWindowRL(int maxRequests, int windowSize) {
        super(RateLimiterContants.MAX_REQUESTS, RateLimiterContants.WINDOW_SIZE);
        this.maxCredits = RateLimiterContants.MAX_CREDITS;

    }

    @Override
    public synchronized boolean allowRequest(String userId) {
        long currTime = System.currentTimeMillis() / 1000;
        long windowStartTs = (currTime / windowSize) * windowSize;

        UserRequestInfo userRequestInfo = userRequests.getOrDefault(userId,
                new CreditUserRequestInfo(windowStartTs, 0, 0));

        if (userRequestInfo.getwindowStartTs() != windowStartTs) {
            CreditUserRequestInfo cRequestInfo = (CreditUserRequestInfo) userRequestInfo;
            if (cRequestInfo.getRequestCount() < maxRequests) {
                int unusedRequests = maxRequests - cRequestInfo.getRequestCount();
                cRequestInfo.setCredits(unusedRequests);
            }
        }

        if (userRequestInfo.getRequestCount() < maxRequests) {
            userRequestInfo.setRequestCount(userRequestInfo.getRequestCount() + 1);
            userRequests.put(userId, userRequestInfo);
            return true;
        }
        return false;
    }

}
