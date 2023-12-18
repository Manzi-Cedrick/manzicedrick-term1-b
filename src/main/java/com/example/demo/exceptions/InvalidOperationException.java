package com.example.demo.exceptions;

public class InvalidOperationException extends Exception {
    public InvalidOperationException(String message){
        super(message);
    }
}