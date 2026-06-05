package com.example.demo.dto;

import java.util.List;

public class TermsAnalysisResponse {

    private String summary;
    private int riskScore;
    private List<String> mainRisks;

    private List<String> detectedClauses;

    private String bestCaseScenario;
    private String realisticScenario;
    private String worstCaseScenario;

    private List<String> redFlags;

    private RiskBreakdown riskBreakdown;

    private String recommendation;

    private NutritionLabel nutritionLabel;

    public TermsAnalysisResponse() {
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(int riskScore) {
        this.riskScore = riskScore;
    }

    public List<String> getMainRisks() {
        return mainRisks;
    }

    public void setMainRisks(List<String> mainRisks) {
        this.mainRisks = mainRisks;
    }

    public List<String> getDetectedClauses() {
        return detectedClauses;
    }

    public void setDetectedClauses(List<String> detectedClauses) {
        this.detectedClauses = detectedClauses;
    }

    public String getBestCaseScenario() {
        return bestCaseScenario;
    }

    public void setBestCaseScenario(String bestCaseScenario) {
        this.bestCaseScenario = bestCaseScenario;
    }

    public String getRealisticScenario() {
        return realisticScenario;
    }

    public void setRealisticScenario(String realisticScenario) {
        this.realisticScenario = realisticScenario;
    }

    public String getWorstCaseScenario() {
        return worstCaseScenario;
    }

    public void setWorstCaseScenario(String worstCaseScenario) {
        this.worstCaseScenario = worstCaseScenario;
    }

    public List<String> getRedFlags() {
        return redFlags;
    }

    public void setRedFlags(List<String> redFlags) {
        this.redFlags = redFlags;
    }

    public RiskBreakdown getRiskBreakdown() {
        return riskBreakdown;
    }

    public void setRiskBreakdown(RiskBreakdown riskBreakdown) {
        this.riskBreakdown = riskBreakdown;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public NutritionLabel getNutritionLabel() {
        return nutritionLabel;
    }

    public void setNutritionLabel(NutritionLabel nutritionLabel) {
        this.nutritionLabel = nutritionLabel;
    }
}