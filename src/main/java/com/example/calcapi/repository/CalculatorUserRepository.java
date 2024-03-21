package com.example.calcapi.repository;

import com.example.calcapi.entity.CalculatorUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CalculatorUserRepository extends CrudRepository<CalculatorUser, Long> {
    CalculatorUser findByName(String Name);
    int findIdByNameAndPassword(String username, String password);
    CalculatorUser save(CalculatorUser user);
}
