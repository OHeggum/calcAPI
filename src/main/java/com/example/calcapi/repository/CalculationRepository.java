package com.example.calcapi.repository;

import com.example.calcapi.entity.Calculation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CalculationRepository extends CrudRepository<Calculation, Long> {
    List<Calculation> getCalculationByUserID(int ID);
}
