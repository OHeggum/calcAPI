package com.example.calcapi.repository;

import com.example.calcapi.entity.CalculatorUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CalculatorUserRepository extends CrudRepository<CalculatorUser, Long> {
    List<CalculatorUser> findCalculatorUserByName(String sr);
    CalculatorUser findByName(String Name);

    List<CalculatorUser> findAppUserById(Long id);
    CalculatorUser findAppUserByNameAndPassword(String username, String password);
}
