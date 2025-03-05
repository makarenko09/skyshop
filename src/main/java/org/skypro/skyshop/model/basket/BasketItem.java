package org.skypro.skyshop.model.basket;

import org.skypro.skyshop.model.product.Product;

import java.util.List;

public final class BasketItem {

Product product;
int quantity;

    public BasketItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
