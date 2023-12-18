package com.example.demo.services;

import com.example.demo.exceptions.InvalidOperationException;

public interface IMathOperatorService {
    double doMath(double operand1, double operand2, String operation) throws InvalidOperationException;
}