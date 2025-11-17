package com.HealthChecker;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SymptoAnalyzer {

    @Autowired
    private SymptomRepository repository;

    public String analyzeSymptoms(List<String> symptoms) {

        if (symptoms == null || symptoms.isEmpty()) {
            return "Please add at least one symptom.";
        }

        String lower = symptoms.toString().toLowerCase();
        String result;

        if (lower.contains("fever") || lower.contains("temperature") || lower.contains("thandi")) {
            result = "You have fever-like symptoms. Take rest & drink water.";
        } else if (lower.contains("cold") || lower.contains("khokla") || lower.contains("cough") || lower.contains("sardi")) {
            result = "You have cold/cough symptoms. Drink warm water.";
        } else {
            result = "Basic symptoms found. Consult a doctor if needed.";
        }

        // Save to MongoDB
        SymptomEntry entry = new SymptomEntry(symptoms, result);
        repository.save(entry);

        return result;
    }
}
