package com.example.CGI.repository;

import com.example.CGI.model.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestEntityRepo extends JpaRepository<TestEntity, Long> {
}
