package com.kantilever.t1c3android.domain;

import com.kantilever.t1c3android.domain.abs.PersistenceEntity;

/**
 * Created by Tom on 5-1-2016.
 */
public class Product extends PersistenceEntity {
    private static final long serialVersionUID = -6842446943022957399L;
    private String name;
    private double price;
    private int stock;

    public Product(final String id, final String name, final double price, final int stock) {
        this.setId(id);
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Product() {
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getStock() {
        return this.stock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String toString() {
        return "com.kantilever.t1c3android.domain.Product(name=" + this.name + ", price=" + this.price + ", stock=" + this.stock + ")";
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Product)) return false;
        final Product other = (Product) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        if (Double.compare(this.getPrice(), other.getPrice()) != 0) return false;
        if (this.getStock() != other.getStock()) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 0 : $name.hashCode());
        final long $price = Double.doubleToLongBits(this.getPrice());
        result = result * PRIME + (int) ($price >>> 32 ^ $price);
        result = result * PRIME + this.getStock();
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Product;
    }
}
