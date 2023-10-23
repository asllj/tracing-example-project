package com.example;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ReportingRepository extends MongoRepository<Report, UUID> {
}
