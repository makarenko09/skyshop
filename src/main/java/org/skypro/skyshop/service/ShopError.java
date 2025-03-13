package org.skypro.skyshop.service;

import org.springframework.http.ResponseEntity;

public class ShopError {
    private final String code;
    private final String message;

    public ShopError(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
