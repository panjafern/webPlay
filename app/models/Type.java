package models;

import play.db.ebean.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Computer on 27/9/2561.
 */
@Entity
@Table
public class Type extends Model {
    @Id
    private String id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "Type",cascade = CascadeType.ALL)
    private List<Product4> product4List = new ArrayList<Product4>();

    public Type() {
    }

    public Type(String id, String name, String description, List<Product4> product4List) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.product4List = product4List;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product4> getProduct4List() {
        return product4List;
    }

    public void setProduct4List(List<Product4> product4List) {
        this.product4List = product4List;
    }

    public static Finder<String, Type> getFinder() {
        return finder;
    }

    public static void setFinder(Finder<String, Type> finder) {
        Type.finder = finder;
    }

    public static Finder<String, Type> finder = new Finder<String, Type>(String.class, Type.class);

    public  static List<Type> list(){
        return finder.all();
    }



}
