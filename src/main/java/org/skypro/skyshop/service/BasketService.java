package org.skypro.skyshop.service;

import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BasketService {
    private final ProductBasket productBasket;
    private final StorageService storageService;

    public BasketService(ProductBasket productBasket, StorageService storageService) {
        this.productBasket = productBasket;
        this.storageService = storageService;
    }

    public void addProductToBasket(/*@Qualifier("addToBasket") */UUID id) {
        Optional<Product> product = storageService.getProductById(id);
        if (product.isPresent() == false) {
            throw new IllegalArgumentException("Product with ID " + id + " not found.");
        } else {
            productBasket.addToBasket(id);
        }
    }

    public UserBasket getUserBasket() {
        Map<UUID, Integer> basketMap = productBasket.getBasket();
        List<BasketItem> basketItemList = basketMap.entrySet().stream()
                .map(map -> new BasketItem(storageService.getProductById(map.getKey()).orElseThrow(), map.getValue()))
                .collect(Collectors.toCollection(()-> new ArrayList<BasketItem>()));
        int total = basketItemList.stream()
                .mapToInt(price -> price.getQuantity() * price.getProduct().getPrice())
                .sum();
        return new UserBasket(basketItemList, total);
    }

    public void printBasket() {
    }
}
