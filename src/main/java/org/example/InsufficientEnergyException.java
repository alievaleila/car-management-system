package org.example;

public class InsufficientEnergyException extends RuntimeException {
    public InsufficientEnergyException(String message) {
        super(message);
    }
}
