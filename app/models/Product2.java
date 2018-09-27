package models;

import java.util.Random;

/**
 * Created by Computer on 21/8/2561.
 */
public class Product2 extends Product {
    private String id;
    private String weight;
    private double discountRate;
    private String picture;

    public Product2() {
        setId();
    }

    public Product2(String mfg, String type, String name, String detail, double price, int amount, String weight, double discountRate, String picture) {
        super(mfg, type, name, detail, price, amount);
        setId();
        this.weight = weight;
        this.discountRate = discountRate;
        this.picture = picture;
    }

    public String getId() {
        return id;
    }

    private void setId() {
        Random random=new Random();
        id=Integer.toString(random.nextInt(100000)+1);
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    public double getNetPrice(){
        return getPrice()-(getPrice()*discountRate);
    }
}