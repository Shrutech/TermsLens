package com.example.demo.service;

import com.example.demo.dto.RiskBreakdown;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskScoringService {

    public RiskBreakdown calculate(List<String> flags) {

        int privacy = 0;
        int financial = 0;
        int legal = 0;

        for (String flag : flags) {

            switch (flag) {

                case "Data Sharing":
                    privacy += 25;
                    break;

                case "Third Party Sharing":
                    privacy += 25;
                    break;

                case "Tracking":
                    privacy += 15;
                    break;

                case "Auto Renewal":
                    financial += 15;
                    break;

                case "Subscription Trap":
                    financial += 25;
                    break;

                case "No Refunds":
                    financial += 25;
                    break;

                case "Arbitration Clause":
                    legal += 15;
                    break;

                case "Liability Waiver":
                    legal += 20;
                    break;

                case "Account Termination":
                    legal += 20;
                    break;

                case "Unilateral Changes":
                    legal += 15;
                    break;

                case "Content Ownership Transfer":
                    legal += 25;
                    break;
            }
        }

        privacy = Math.min(privacy, 100);
        financial = Math.min(financial, 100);
        legal = Math.min(legal, 100);

        int overall =
                (privacy * 45
                        + financial * 25
                        + legal * 35)
                        / 100;


        int flagBonus = flags.size() * 4;
        overall += flagBonus;
        
        overall = Math.min(overall, 100);

        RiskBreakdown breakdown =
                new RiskBreakdown();

        breakdown.setPrivacyRisk(privacy);
        breakdown.setFinancialRisk(financial);
        breakdown.setLegalRisk(legal);
        breakdown.setOverallRisk(overall);

        return breakdown;
    }
}