package org.skypro.skyshop.service;

import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.product.Product;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BasketService {
    private final ProductBasket productBasket;
    private final StorageService storageService;

    public BasketService(ProductBasket productBasket, StorageService storageService) {
        this.productBasket = productBasket;
        this.storageService = storageService;
    }

    public void addProductToBasket(UUID id) {
        Product product = storageService.getProductById(id).orElseThrow(NoSuchProductException::new);
            productBasket.addToBasket(id);
    }

    public UserBasket getUserBasket() {
        Map<UUID, Integer> basketMap = productBasket.getBasket();
        List<BasketItem> basketItemList = basketMap.entrySet().stream()
                .map(map -> new BasketItem(storageService.getProductById(map.getKey()).orElseThrow(NoSuchProductException::new), map.getValue()))
                .collect(Collectors.toCollection(()-> new ArrayList<BasketItem>()));
        int total = basketItemList.stream()
                .mapToInt(price -> price.getQuantity() * price.getProduct().getPrice())
                .sum();
        return new UserBasket(basketItemList, total);
    }

}
