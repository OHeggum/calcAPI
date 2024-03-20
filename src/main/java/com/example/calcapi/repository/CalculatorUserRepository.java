package com.example.calcapi.repository;

import com.example.calcapi.entity.CalculatorUser;
import org.springframework.data.repository.CrudRepository;

public interface CalculatorUserRepository extends CrudRepository<CalculatorUser, Long> {
}
