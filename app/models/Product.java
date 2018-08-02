package models;

/**
 * Created by Computer on 12/7/2561.
 */
public class Product {
    private String id,type,name,detail;
    private double price;
    private int amount;

    public Product() {
    }

    public Product(String id, String type, String name, String detail, double price, int amount) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.detail = detail;
        this.price = price;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

