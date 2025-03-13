package org.skypro.skyshop.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ShopControllerAdvice extends RuntimeException {


    @ExceptionHandler(NoSuchProductException.class)
    public ResponseEntity<ShopError> handleNoSuchProductException
            (NoSuchProductException e) {
        String errorCode = "PRODUCT_NOT_FOUND";
        String errorMessage = e.getMessage();

        ShopError shopError = new ShopError(errorCode, errorMessage);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(shopError);
//        return ResponseEntity.status(HttpStatusCode.valueOf(404)).body(shopError);
    }
}
