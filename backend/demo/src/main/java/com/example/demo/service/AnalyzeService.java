package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class AnalyzeService {

    public String analyze(String text) {
        return """
                SUMMARY:
                This is a demo response.

                USER TEXT:
                """ + text;
    }
}