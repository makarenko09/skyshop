package org.skypro.skyshop.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;
import java.util.regex.Pattern;

public abstract class Product implements Searchable {
    protected String name;
    private final UUID uuid;

    @Override
    public UUID getId() {
        return uuid;
    }

    public Product(String name, UUID uuid) {
        if (!Pattern.matches("^.{2,20}$", name)) {
            System.out.println("Product.getName");
            System.out.println("Name.Exc.toString{" +
                    "name='" + name + '}');
            throw new IllegalArgumentException("Некорректное имя продукта");
        }
        this.name = name;
        if (uuid == null) {
            this.uuid = UUID.randomUUID();
        } else this.uuid = uuid;
    }

    public Product(String name) {
        if (!Pattern.matches("^.{2,20}$", name)) {
            System.out.println("Product.getName");
            System.out.println("Name.Exc.toString{" +
                    "name='" + name + '}');
            throw new IllegalArgumentException("Некорректное имя продукта");
        }
        this.name = name;
        this.uuid = UUID.randomUUID();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Product)) return false;
        return Objects.equals(name, ((Product) o).name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    @JsonIgnore
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    @JsonIgnore
    public String getSearchTerm() {
        return name;

    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    public String getName() {

        if (name == null) {
            throw new IllegalArgumentException("Имя продукта не может быть null");
        }
        return this.name;
    }

    public String toString() {
        return "name='" + name + '\'';
    }
}