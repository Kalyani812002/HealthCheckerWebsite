package com.HealthChecker;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/api/health")
@CrossOrigin(origins = "*")
public class HealthController {

    @Autowired
    private SymptoAnalyzer analyzer;

    @PostMapping("/check")
    public String checkSymptoms(@RequestBody SymptomRequest request) {
        List<String> symptoms = request.getSymptoms();
        return analyzer.analyzeSymptoms(symptoms);
    }
}
