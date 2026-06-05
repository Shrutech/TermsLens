package com.example.demo.dto;

public class RiskBreakdown {

    private int privacyRisk;
    private int financialRisk;
    private int legalRisk;
    private int overallRisk;

    public int getPrivacyRisk() {
        return privacyRisk;
    }

    public void setPrivacyRisk(int privacyRisk) {
        this.privacyRisk = privacyRisk;
    }

    public int getFinancialRisk() {
        return financialRisk;
    }

    public void setFinancialRisk(int financialRisk) {
        this.financialRisk = financialRisk;
    }

    public int getLegalRisk() {
        return legalRisk;
    }

    public void setLegalRisk(int legalRisk) {
        this.legalRisk = legalRisk;
    }

    public int getOverallRisk() {
        return overallRisk;
    }

    public void setOverallRisk(int overallRisk) {
        this.overallRisk = overallRisk;
    }
}