package com.example.demo.service;

import net.sourceforge.tess4j.Tesseract;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class OcrService {

    public String extractText(File imageFile) {

        try {

            System.out.println("Image path: " + imageFile.getAbsolutePath());

            Tesseract tesseract = new Tesseract();

            tesseract.setDatapath("tessdata");
            tesseract.setLanguage("eng");

            String result = tesseract.doOCR(imageFile);

            System.out.println("OCR SUCCESS");

            return result;

        } catch (Exception e) {

            e.printStackTrace();

            return "OCR Error: " + e.getMessage();
        }
    }
}