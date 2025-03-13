package org.skypro.skyshop.service;

import org.apache.coyote.Response;
import org.skypro.skyshop.controller.ShopController;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.Controller;

import java.time.LocalDateTime;

@ControllerAdvice(assignableTypes = ShopController.class)
public class ShopControllerAdvice extends RuntimeException {

    @ExceptionHandler(NoSuchProductException.class)
    public ResponseEntity<ShopError> handleNoSuchProductException
            (NoSuchProductException e) {
        String code = "PRODUCT_NOT_FOUND";
        String message = String.format("%s %s", LocalDateTime.now(), e.getMessage());
        ShopError shopError = new ShopError(code, message);
        return new ResponseEntity<ShopError>(shopError, HttpStatusCode.valueOf(404));
//        return ResponseEntity.status(HttpStatusCode.valueOf(404)).body(shopError);
    }
}
