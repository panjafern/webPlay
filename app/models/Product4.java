package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by Computer on 27/9/2561.
 */
@Entity
@Table
public class Product4 extends Model {
    @Id
    private String id;
    private String name,detail,exp;
    private double price;
    private int amount;
    @ManyToOne
    private Product4 product4;

    public Product4() {
    }

    public Product4(String id, String name, String detail, String exp, double price, int amount, Product4 product4) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.exp = exp;
        this.price = price;
        this.amount = amount;
        this.product4 = product4;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
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

    public Product4 getProduct4() {
        return product4;
    }

    public void setProduct4(Product4 product4) {
        this.product4 = product4;
    }

    public static void List<Product4> list() {
        return finder.all();
    }

}
