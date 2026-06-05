package com.example.demo.service;

import com.example.demo.dto.NutritionLabel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NutritionLabelService {

    public NutritionLabel generate(List<String> flags) {

        NutritionLabel label =
                new NutritionLabel();

        int dataSharing = 0;
        int tracking = 0;
        int subscription = 0;
        int termination = 0;

        for (String flag : flags) {

            switch (flag) {

                case "Data Sharing":
                    dataSharing = 70;
                    break;

                case "Third Party Sharing":
                    dataSharing =
                            Math.max(dataSharing, 85);
                    break;

                case "Tracking":
                    tracking = 30;
                    break;

                case "Auto Renewal":
                    subscription = 50;
                    break;

                case "Subscription Trap":
                    subscription = 80;
                    break;

                case "Account Termination":
                    termination = 70;
                    break;
            }
        }

        label.setDataSharing(dataSharing);
        label.setTracking(tracking);
        label.setSubscription(subscription);
        label.setTermination(termination);

        return label;
    }
}