package org.skypro.skyshop.model.product;

import java.util.UUID;

public class FixPriceProduct extends Product {
    private final int FIX_PRICE = 100;
    private final UUID uuid;

    public FixPriceProduct(String name,UUID uuid) {
        super(name, uuid);
        if (uuid == null) {
            this.uuid = UUID.randomUUID();
        } else this.uuid = uuid;
    }

    public FixPriceProduct(String name) {
        super(name);
        this.uuid = UUID.randomUUID();
    }

    @Override
    public int getPrice() {
        return FIX_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return "<" + getName() + ">:" + " " + "Фиксированная цена" + " " + "<" + getPrice() + ">";
    }
}
