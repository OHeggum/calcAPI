package com.example.calcapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Calculation {
    @Id
    @GeneratedValue
    private Long id;
    private double op1;
    private double op2;
    private double operator;

    public Calculation(double op1, double op2, double operator) {
        this.op1 = op1;
        this.op2 = op2;
        this.operator = operator;
    }

    public Calculation() {

    }

    public double getOp1() {
        return op1;
    }

    public void setOp1(double op1) {
        this.op1 = op1;
    }

    public double getOp2() {
        return op2;
    }

    public void setOp2(double op2) {
        this.op2 = op2;
    }

    public double getOperator() {
        return operator;
    }

    public void setOperator(double operator) {
        this.operator = operator;
    }
}
