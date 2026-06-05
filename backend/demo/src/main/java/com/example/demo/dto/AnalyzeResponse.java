package com.example.demo.dto;

public class AnalyzeResponse {

    private String result;

    public AnalyzeResponse() {
    }

    public AnalyzeResponse(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}