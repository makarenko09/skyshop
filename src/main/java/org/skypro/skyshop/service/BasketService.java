package org.skypro.skyshop.service;

import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class BasketService {
    private final ProductBasket productBasket;
    private final StorageService storageService;

    public BasketService(ProductBasket productBasket, StorageService storageService) {
        this.productBasket = productBasket;
        this.storageService = storageService;
            }

    public void addProductToBasket(@Qualifier("addToBasket") UUID id) {
        Optional<Product> product = storageService.getProductById(id);
        if (product.isPresent() == false) {
            throw new IllegalArgumentException();
        } else {
            productBasket.addToBasket(id);
        }
    }

    public void printBasket() {
    }

public UserBasket getUserBasket(){
        return null;
}
}
