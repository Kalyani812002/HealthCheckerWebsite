package com.HealthChecker;

import java.util.List;

public class SymptomRequest {

    private List<String> symptoms;

    public SymptomRequest() {
    }

    public List<String> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<String> symptoms) {
        this.symptoms = symptoms;
    }
}
