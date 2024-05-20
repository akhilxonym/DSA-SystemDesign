package src.model;

public class UserRequestInfo {
    long windowStartTs;
    int requestCount;

    public UserRequestInfo(long windowStartTs, int requestCount) {
        this.requestCount = requestCount;
        this.windowStartTs = windowStartTs;
    }

    public long getwindowStartTs() {
        return windowStartTs;
    }

    public void setwindowStartTs(long windowStartTs) {
        this.windowStartTs = windowStartTs;
    }

    public int getRequestCount() {
        return requestCount;
    }

    public void setRequestCount(int requestCount) {
        this.requestCount = requestCount;
    }

}
