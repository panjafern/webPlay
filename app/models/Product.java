package models;

import java.util.Random;

/**
 * Created by Computer on 12/7/2561.
 */
public class Product {
    private String mfg, type, name, detail;
    private double price;
    private int amount;

    public Product() {
    }

    public Product(String mfg, String type, String name, String detail, double price, int amount) {
        this.mfg = mfg;
        this.type = type;
        this.name = name;
        this.detail = detail;
        this.price = price;
        this.amount = amount;
    }

    public String getMfg() {
        return mfg;
    }

    public void setMfg(String mfg) {
        this.mfg = mfg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}