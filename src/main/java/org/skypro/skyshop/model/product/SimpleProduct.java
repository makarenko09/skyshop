package org.skypro.skyshop.model.product;

import java.util.UUID;

public class SimpleProduct extends Product {
    private final UUID uuid;
    private int price;

    public SimpleProduct(int price, String name,UUID uuid) {
        super(name, uuid);
        if (price == 0 || price < 0) {
            System.out.println("Price.Exc.ZeroDownANDZero.toString{" +
                    "price=" + price +
                    '}');
            throw new IllegalArgumentException();
        }
        this.price = price;
        if (uuid == null) {
            this.uuid = UUID.randomUUID();
        } else this.uuid = uuid;
    }

    public SimpleProduct(int price, String name) {
        super(name);
        if (price == 0 || price < 0) {
            System.out.println("Price.Exc.ZeroDownANDZero.toString{" +
                    "price=" + price +
                    '}');
            throw new IllegalArgumentException();
        }
        this.price = price;
        this.uuid = UUID.randomUUID();
    }


    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "<" + this.getName() + ">:" + " " + "<" + this.getPrice() + ">";
    }
}
