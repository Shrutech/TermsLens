package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RedFlagService {

    public List<String> detectFlags(String text) {

        String lower = text.toLowerCase();

        List<String> flags = new ArrayList<>();

        if (
                lower.contains("share")
                        && (
                        lower.contains("data")
                                || lower.contains("information")
                                || lower.contains("personal")
                                || lower.contains("user")
                )
        ) {
            flags.add("Data Sharing");
        }

        if (
                lower.contains("third party")
                        || lower.contains("third-party")
                        || lower.contains("third parties")
                        || lower.contains("affiliate")
                        || lower.contains("advertiser")
                        || lower.contains("advertising partner")
                        || lower.contains("marketing partner")
                        || lower.contains("marketing partners")
                        || lower.contains("business partner")
                        || lower.contains("external partner")
                        || lower.contains("partner companies")
                        || lower.contains("data broker")
                        || lower.contains("service provider")
        ) {
            flags.add("Third Party Sharing");
        }

        if (
                lower.contains("track")
                        || lower.contains("tracking")
                        || lower.contains("location")
                        || lower.contains("analytics")
                        || lower.contains("behavioral")
                        || lower.contains("usage data")
                        || lower.contains("device information")
                        || lower.contains("monitor activity")
        ) {
            flags.add("Tracking");
        }

        if (
                lower.contains("automatic renewal")
                        || lower.contains("auto renew")
                        || lower.contains("auto-renew")
                        || lower.contains("renew automatically")
                        || lower.contains("automatically renew")
        ) {
            flags.add("Auto Renewal");
        }

        if (
                lower.contains("subscription")
                        || lower.contains("recurring payment")
                        || lower.contains("recurring charge")
                        || lower.contains("monthly billing")
                        || lower.contains("annual billing")
                        || lower.contains("billing cycle")
        ) {
            flags.add("Subscription Trap");
        }

        if (
                lower.contains("arbitration")
                        || lower.contains("binding arbitration")
                        || lower.contains("resolved by arbitration")
        ) {
            flags.add("Arbitration Clause");
        }

        if (
                lower.contains("waive")
                        || lower.contains("waiver")
                        || lower.contains("waive jury")
                        || lower.contains("jury trial")
                        || lower.contains("limitation of liability")
                        || lower.contains("liability waiver")
                        || lower.contains("not liable")
                        || lower.contains("no liability")
        ) {
            flags.add("Liability Waiver");
        }

        if (
                lower.contains("terminate")
                        || lower.contains("termination")
                        || lower.contains("suspend account")
                        || lower.contains("account may be terminated")
                        || lower.contains("close your account")
                        || lower.contains("remove your account")
        ) {
            flags.add("Account Termination");
        }

        if (
                lower.contains("non-refundable")
                        || lower.contains("no refund")
                        || lower.contains("no refunds")
                        || lower.contains("payments are final")
                        || lower.contains("all sales are final")
        ) {
            flags.add("No Refunds");
        }

        if (
                lower.contains("modify these terms")
                        || lower.contains("change these terms")
                        || lower.contains("update these terms")
                        || lower.contains("monitor updates")
                        || lower.contains("continued use constitutes acceptance")
                        || lower.contains("without notice")
        ) {
            flags.add("Unilateral Changes");
        }

        if (
                lower.contains("exclusive property")
                        || lower.contains("becomes our property")
                        || lower.contains("ownership of content")
                        || lower.contains("user-generated content becomes")
        ) {
            flags.add("Content Ownership Transfer");
        }

        return flags;
    }
}