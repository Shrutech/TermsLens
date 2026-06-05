package com.example.demo.dto;

public class NutritionLabel {

    private int dataSharing;
    private int tracking;
    private int subscription;
    private int termination;

    public int getDataSharing() {
        return dataSharing;
    }

    public void setDataSharing(int dataSharing) {
        this.dataSharing = dataSharing;
    }

    public int getTracking() {
        return tracking;
    }

    public void setTracking(int tracking) {
        this.tracking = tracking;
    }

    public int getSubscription() {
        return subscription;
    }

    public void setSubscription(int subscription) {
        this.subscription = subscription;
    }

    public int getTermination() {
        return termination;
    }

    public void setTermination(int termination) {
        this.termination = termination;
    }
}