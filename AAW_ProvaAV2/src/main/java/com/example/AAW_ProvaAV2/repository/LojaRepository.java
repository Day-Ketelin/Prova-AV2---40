package com.example.AAW_ProvaAV2.repository;

import com.example.AAW_ProvaAV2.model.LoginRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LojaRepository extends MongoRepository<LoginRequest, String> {
}
