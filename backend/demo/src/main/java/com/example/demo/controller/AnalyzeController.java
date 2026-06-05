package com.example.demo.controller;

import com.example.demo.dto.AnalyzeRequest;
import com.example.demo.dto.TermsAnalysisResponse;
import com.example.demo.service.GeminiService;
import com.example.demo.service.NutritionLabelService;
import com.example.demo.service.OcrService;
import com.example.demo.service.RedFlagService;
import com.example.demo.service.RecommendationService;
import com.example.demo.service.RiskScoringService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AnalyzeController {

    private final GeminiService geminiService;
    private final OcrService ocrService;
    private final RiskScoringService riskScoringService;
    private final RedFlagService redFlagService;
    private final RecommendationService recommendationService;
    private final NutritionLabelService nutritionLabelService;

    public AnalyzeController(
            GeminiService geminiService,
            OcrService ocrService,
            RiskScoringService riskScoringService,
            RedFlagService redFlagService,
            RecommendationService recommendationService,
            NutritionLabelService nutritionLabelService
    ) {
        this.geminiService = geminiService;
        this.ocrService = ocrService;
        this.riskScoringService = riskScoringService;
        this.redFlagService = redFlagService;
        this.recommendationService = recommendationService;
        this.nutritionLabelService = nutritionLabelService;
    }

    @PostMapping("/analyze")
    public TermsAnalysisResponse analyze(
            @RequestBody AnalyzeRequest request
    ) {

        TermsAnalysisResponse result =
                geminiService.analyzeTerms(
                        request.getText()
                );

        List<String> mergedFlags =
                mergeFlags(
                        request.getText(),
                        result.getDetectedClauses()
                );

        result.setRedFlags(mergedFlags);

        result.setRiskBreakdown(
                riskScoringService.calculate(
                        mergedFlags
                )
        );

        result.setNutritionLabel(
                nutritionLabelService.generate(
                        mergedFlags
                )
        );

        result.setRiskScore(
                result.getRiskBreakdown()
                        .getOverallRisk()
        );

        result.setRecommendation(
                recommendationService.getRecommendation(
                        result.getRiskScore()
                )
        );

        return result;
    }

    @PostMapping("/analyze-image")
    public TermsAnalysisResponse analyzeImage(
            @RequestParam("file") MultipartFile file
    ) {

        try {

            File tempFile =
                    File.createTempFile(
                            "upload",
                            file.getOriginalFilename()
                    );

            file.transferTo(tempFile);

            String extractedText =
                    ocrService.extractText(tempFile);

            TermsAnalysisResponse result =
                    geminiService.analyzeTerms(
                            extractedText
                    );

            List<String> mergedFlags =
                    mergeFlags(
                            extractedText,
                            result.getDetectedClauses()
                    );

            result.setRedFlags(mergedFlags);

            result.setRiskBreakdown(
                    riskScoringService.calculate(
                            mergedFlags
                    )
            );

            result.setNutritionLabel(
                    nutritionLabelService.generate(
                            mergedFlags
                    )
            );

            result.setRiskScore(
                    result.getRiskBreakdown()
                            .getOverallRisk()
            );

            result.setRecommendation(
                    recommendationService.getRecommendation(
                            result.getRiskScore()
                    )
            );

            return result;

        } catch (Exception e) {

            TermsAnalysisResponse error =
                    new TermsAnalysisResponse();

            error.setSummary(
                    "Error: " + e.getMessage()
            );

            return error;
        }
    }

    private List<String> mergeFlags(
            String text,
            List<String> aiFlags
    ) {

        List<String> merged =
                new ArrayList<>(
                        redFlagService.detectFlags(text)
                );

        if (aiFlags != null) {

            for (String flag : aiFlags) {

                if (!merged.contains(flag)) {
                    merged.add(flag);
                }
            }
        }

        return merged;
    }
}