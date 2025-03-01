package org.skypro.skyshop.model.product;

import java.util.UUID;

public class DiscountedProduct extends Product {
    private int basicPrice;
    private int discountInTargetCurrencies;
    private final UUID uuid;

    public DiscountedProduct(String name, int basicPrice, int discountInTargetCurrencies,UUID uuid) {
        super(name, uuid);
        if (basicPrice < 0) {
            System.out.println("BasicPrice.Exc.ZeroDown.toString{" +
                    "price=" + basicPrice +
                    '}');
            throw new IllegalArgumentException("Цена не может быть ниже нуля");
        }
        if ((discountInTargetCurrencies < 0 || discountInTargetCurrencies > 100)) {
            System.out.println("Discount.Exc.Value{" +
                    "discount=" + discountInTargetCurrencies +
                    ", price=" + basicPrice +
                    '}');
            throw new IllegalArgumentException("Скидка не может быть ниже 0 и больше 100-та");
        }
        this.discountInTargetCurrencies = discountInTargetCurrencies;
        this.basicPrice = basicPrice;
        if (uuid == null) {
            this.uuid = UUID.randomUUID();
        } else this.uuid = uuid;
    }

    public DiscountedProduct(String name, int basicPrice, int discountInTargetCurrencies) {
        super(name);
        if (basicPrice < 0) {
            System.out.println("BasicPrice.Exc.ZeroDown.toString{" +
                    "price=" + basicPrice +
                    '}');
            throw new IllegalArgumentException("Цена не может быть ниже нуля");
        }
        if ((discountInTargetCurrencies < 0 || discountInTargetCurrencies > 100)) {
            System.out.println("Discount.Exc.Value{" +
                    "discount=" + discountInTargetCurrencies +
                    ", price=" + basicPrice +
                    '}');
            throw new IllegalArgumentException("Скидка не может быть ниже 0 и больше 100-та");
        }
        this.discountInTargetCurrencies = discountInTargetCurrencies;
        this.basicPrice = basicPrice;
        this.uuid = UUID.randomUUID();
    }


    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public int getPrice() {
        return basicPrice * (100 - discountInTargetCurrencies) / 100;
    }

    public int getDiscountInTargetCurrencies() {
        return discountInTargetCurrencies;
    }

    @Override
    public String toString() {
        return "<" + getName() + ">:" + " " + "<" + getPrice() + ">" + "(<" + discountInTargetCurrencies + ">%)";
    }
}
