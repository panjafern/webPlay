package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by Computer on 30/8/2561.
 */
@Entity
@Table

public class Product3 extends Model {
    @Id
    private String id;
    private String type, name, detail,weight,mfg,exp;
    private double price,discountRate;
    private int amount;


    public Product3() {
    }

    public Product3(String id, String type, String name, String detail, String weight, String mfg, String exp, double price, double discountRate, int amount) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.detail = detail;
        this.weight = weight;
        this.mfg = mfg;
        this.exp = exp;
        this.price = price;
        this.discountRate = discountRate;
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

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getMfg() {
        return mfg;
    }

    public void setMfg(String mfg) {
        this.mfg = mfg;
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

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public static void create(Product3 product3){
        product3.save();
    }
    public static void update(Product3 product3){
        product3.update();
    }
    public static void delete(Product3 product3){
        product3.delete();
    }

    public static Finder<String,Product3> finder = new Finder<String,Product3>(String.class,Product3.class); //เป็นการประกาศตัวแปร finder

    public static List<Product3> list(){

        return finder.all();
    } //เป็น method ใช้ในการดึงข้อมูลเหมือน select * from
}

