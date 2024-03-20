package com.example.calcapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class CalculatorUser {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String password;

    public CalculatorUser(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public CalculatorUser() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "CalculatorUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
