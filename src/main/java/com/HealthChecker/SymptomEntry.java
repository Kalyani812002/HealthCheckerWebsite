package com.HealthChecker;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "symptoms")
public class SymptomEntry {

    @Id
    private String id;
    private String symptom;

    public SymptomEntry() {}

    public SymptomEntry(List<String> symptoms, String symptom) {
        this.symptom = symptom;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }
}
