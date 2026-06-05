package com.example.demo.service;

import com.example.demo.dto.TermsAnalysisResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class GeminiService {

    @Value("${openrouter.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public TermsAnalysisResponse analyzeTerms(String termsText) {

        String url = "https://openrouter.ai/api/v1/chat/completions";

        String prompt = """
                Analyze these Terms and Conditions.

                Return ONLY valid JSON.

                Use exactly this format:

                {
                    "summary": "...",

                    "mainRisks": [
                        "..."
                    ],
                    "detectedClauses": [
                        "..."
                    ],

                    "bestCaseScenario": "...",
                    "realisticScenario": "...",
                    "worstCaseScenario": "..."
                }

                IMPORTANT:

                detectedClauses must contain ONLY values from this list:

                - Data Sharing
                - Third Party Sharing
                - Tracking
                - Auto Renewal
                - Subscription Trap
                - Arbitration Clause
                - Liability Waiver
                - Account Termination
                - No Refunds
                - Unilateral Changes
                - Content Ownership Transfer

                Never invent new clause names.

                Rules:

                1.Generate three practical scenarios.

                2. bestCaseScenario:
                Most favorable realistic outcome.

                3. realisticScenario:
                Most likely outcome for an average user.

                4.worstCaseScenario:
                Most harmful plausible outcome.

                5.mainRisks should contain detailed explanations.
                
                6. detected Clauses should identify all important legal/privacy/financial risks present in the text.
                
                7. Very Important:
                Only include a clause if it is EXPLICITLY present in the text.
                Do not infer.
                Do not speculate.
                Do not assume future policy changes.
                If a clause is absent, do not include it.
                
                8. VERY IMPORTANT:

                Do NOT classify a clause as Data Sharing,
                Third Party Sharing,
                Tracking,
                Auto Renewal,
                No Refunds,
                Account Termination,
                or Liability Waiver
                unless the text EXPLICITLY grants that right.

                If the agreement says:

                - "not shared with third parties"
                - "never sold"
                - "users may delete accounts"
                - "only used for core functionality"

                then do NOT infer risk clauses.

                When uncertain, return no clause rather than a false positive.

                Terms:
                """ + termsText;

        List<String> models = List.of(
                "google/gemma-4-31b-it:free",
                "poolside/laguna-m.1:free"
        );

        for (String model : models) {

            try {

                Map<String, Object> body = Map.of(
                        "model", model,
                        "messages", new Object[]{
                                Map.of(
                                        "role", "user",
                                        "content", prompt
                                )
                        }
                );

                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                headers.setBearerAuth(apiKey);

                HttpEntity<Map<String, Object>> request =
                        new HttpEntity<>(body, headers);

                String response = restTemplate.postForObject(
                        url,
                        request,
                        String.class
                );

                JsonNode root = objectMapper.readTree(response);

                String content = root
                        .path("choices")
                        .get(0)
                        .path("message")
                        .path("content")
                        .asText();

                TermsAnalysisResponse result =
                        objectMapper.readValue(
                                content,
                                TermsAnalysisResponse.class
                        );

                if (result.getRedFlags() == null) {
                    result.setRedFlags(List.of());
                }

                if (result.getDetectedClauses() == null) {
                    result.setDetectedClauses(List.of());
                }

                return result;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        TermsAnalysisResponse fallback =
                new TermsAnalysisResponse();

        fallback.setSummary(
                "AI service temporarily unavailable."
        );
        
        fallback.setRedFlags(List.of());

        return fallback;
    }
}