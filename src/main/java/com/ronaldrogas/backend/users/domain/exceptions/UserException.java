package com.ronaldrogas.backend.users.domain.exceptions;

public class UserException extends RuntimeException {
    public UserException(String message) {
        super(message);
    }
}