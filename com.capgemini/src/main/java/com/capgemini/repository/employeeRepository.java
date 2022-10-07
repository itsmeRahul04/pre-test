package com.capgemini.repository;

import com.capgemini.entity.employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface employeeRepository extends MongoRepository<employee,Long> {
}
