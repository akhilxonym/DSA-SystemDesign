package src.model;

public class CreditUserRequestInfo extends UserRequestInfo {
    int credits;

    public CreditUserRequestInfo(long windowStartTs, int requestCount, int credits) {
        super(windowStartTs, requestCount);
        this.credits = credits;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

}
