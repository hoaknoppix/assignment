package com.hoaqt.assignment.exceptions;

public class OutOfStockException extends RuntimeException {
    public OutOfStockException() {
        super("Out of Stock");
    }
}
