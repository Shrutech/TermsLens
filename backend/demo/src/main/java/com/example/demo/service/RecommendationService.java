package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class RecommendationService {

    public String getRecommendation(int overallRisk) {

        if (overallRisk <= 15) {
            return "Negligible Risk";
        }

        if (overallRisk <= 30) {
            return "Low Risk";
        }

        if (overallRisk <= 50) {
            return "Medium Risk";
        }

        if (overallRisk <= 70) {
            return "Medium-High Risk";
        }

        if (overallRisk <= 85) {
            return "High Risk";
        }

        return "Very High Risk";
    }
}