package org.skypro.skyshop.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

public class NoSuchProductException extends RuntimeException {
    public NoSuchProductException() {
        super();
    }
}
