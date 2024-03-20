package com.example.calcapi.repository;

import com.example.calcapi.entity.Calculation;
import org.springframework.data.repository.CrudRepository;

public interface CalculationRepository extends CrudRepository<Calculation, Long> {
}
