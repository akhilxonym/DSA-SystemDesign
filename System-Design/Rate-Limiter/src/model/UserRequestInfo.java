package src.model;

public class UserRequestInfo {
    int windowSize;
    int requestCount;

    UserRequestInfo(int windowSize, int requestCount) {
        this.requestCount = requestCount;
        this.windowSize = windowSize;
    }
}
