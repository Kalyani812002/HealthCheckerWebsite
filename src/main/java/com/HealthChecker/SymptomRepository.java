package com.HealthChecker;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SymptomRepository extends MongoRepository<SymptomEntry, String> {
}
