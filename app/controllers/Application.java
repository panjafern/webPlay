package controllers;

import models.Product;
import models.Product2;
import models.Product3;
import models.Register;
import play.*;
import play.api.templates.Html;
import play.data.DynamicForm;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.*;
import views.html.*;

import java.awt.*;
import java.io.File;
import java.util.*;
import java.util.List;

import static models.Product3.finder;

public class Application extends Controller {

    public static Product pro1 = new Product("13/01/2561", "NARS", "Concealer Matte", "Concealer", 500, 10);
    public static Product pro2 = new Product("13/01/2561", "MAC", "Matte Lipstick", "Lipstick", 850, 10);
    public static Product pro3 = new Product("13/01/2561", "TARTE", "Eyeshadow Palette", "Eyeshadow", 1400, 10);
    public static Product pro4 = new Product("13/01/2561", "ZOEVA", "Eyeshadow Palette", "Eyeshadow", 600, 10);
    public static Product pro5 = new Product("13/01/2561", "CLINIQUE", "Blush on Hot Pink", "Blushon", 1000, 10);
    public static Product pro6 = new Product("13/01/2561", "KAT VON D", " Liquid Lipstick", "Lipstick", 900, 10);

    public static Register register;

    public static Product product;
    public static Form<Product> productForm = Form.form(Product.class);
    public static List<Product> productList = new ArrayList<Product>();

    public static Form<Product2> product2Form = Form.form(Product2.class);
    public static List<Product2> product2List = new ArrayList<Product2>();
    public static Product2 product2;
    public static String comPicPath = Play.application().configuration().getString("com_pic_path");

    public static Form<Product3> product3Form = Form.form(Product3.class);
    public static List<Product3> product3List = new ArrayList<Product3>();

    public static Product3 product3;

    public static Result main(Html content) {
        return ok(main.render(content));
    }

    public static Result index() {
        return main(home_page.render());
    }

    public static Result lipstick() {
        return main(lipstick.render());
    }

    public static Result eyeshadow() {
        return main(eyeshadow.render());
    }

    public static Result blushon() {
        return main(blushon.render());
    }

    public static Result concealer() {
        return main(concealer.render());
    }

    public static Result promotion() {
        return main(promotion.render());
    }

    public static Result header() {
        return main(header.render());
    }

    public static Result location() {
        return main(location.render());
    }


    public static Result showPro() {
        return main(showPro.render(pro1, pro2, pro3, pro4, pro5, pro6));
    }


    public static Result register_form() {
        return main(register_form.render());
    }

    public static Result product_form() {
        return main(product_from.render());
    }


    public static Result register_post() {
        DynamicForm myForm = Form.form().bindFromRequest();
        String surname, birthday, gender, phone, email, address;

        surname = myForm.get("surname");
        birthday = myForm.get("birthday");
        gender = myForm.get("gender");
        phone = myForm.get("phone");
        email = myForm.get("email");
        address = myForm.get("address");

        register = new Register(surname, birthday, gender, phone, email, address);

        return main(register_show.render(register));
    }

    public static Result product_post() {
        DynamicForm myForm1 = Form.form().bindFromRequest();
        String mfg, type, name, detail;
        double price;
        int amount;

        mfg = myForm1.get("mfg");
        type = myForm1.get("type");
        name = myForm1.get("name");
        detail = myForm1.get("detail");
        price = Double.parseDouble(myForm1.get("price"));
        amount = Integer.parseInt(myForm1.get("amount"));

        product = new Product(mfg, type, name, detail, price, amount);

        return main(product_show.render(product));
    }

    public static Result product_form_helper() {
        productForm = Form.form(Product.class);
        return ok(product_form_helper.render(productForm));
    }

    public static Result product_post_helper() {
        Form<Product> newForm = productForm.bindFromRequest();
        if (newForm.hasErrors()) {
            return ok(product_form_helper.render(newForm));
        } else {
            product = newForm.get();
            return ok(product_show_helper.render(product));
        }
    }

    public static Result product_form_helper_list() {
        productForm = Form.form(Product.class);
        return ok(product_form_helper_list.render(productForm));
    }

    public static Result product_post_helper_list() {
        Form<Product> newForm = productForm.bindFromRequest();
        if (newForm.hasErrors()) {
            return ok(product_form_helper.render(newForm));
        } else {
            product = newForm.get();
            productList.add(product);
            return ok(product_show_helper_list.render(productList));
        }
    }

    public static Result product2_form_helper_list() {
        product2Form = Form.form(Product2.class);
        return main(product2_form_helper_list.render(product2Form));
    }

    public static Result product2_post_helper_list() {
        Form<Product2> myForm = product2Form.bindFromRequest();
        Http.MultipartFormData body = request().body().asMultipartFormData();
        Http.MultipartFormData.FilePart picture = body.getFile("picture");
        String fileName, contentType;
        if (myForm.hasErrors()) {
            return main(product2_form_helper_list.render(myForm));
        } else {
            if (picture != null) {
                contentType = picture.getContentType();
                File file = picture.getFile();
                fileName = picture.getFilename();
                if (!contentType.startsWith("image")) {
                    return main(product2_form_helper_list.render(myForm));
                }
                product2 = myForm.get();
                fileName = product2.getId() + fileName.substring(fileName.lastIndexOf("."));
                file.renameTo(new File(comPicPath, fileName));
                product2.setPicture(fileName);
                product2List.add(product2);
            }
            return main(product2_show_helper_list.render(product2List));
        }
    }

    public static Result showOne(String id) {
        for (int i = 0; i < product2List.size(); i++) {
            if (product2List.get(i).getId().equals(id)) {
                product2 = product2List.get(i);
                break;
            }

        }

        return main(showOne_list.render(product2));
    }

    public static Result testAddProduct3(){
        Product3 pro1 = new Product3("001","Lipstick","MAC","Lipstick Matte","15","12/01/2560","12/01/2562",500,0.05,10);
        Product3.create(pro1);
        return ok();
    }

    public static Result listProduct3(){
        product3List= Product3.list();
        return main(listProduct3.render(product3List));
    }

    public static Result inputProduct3(){
        product3Form = Form.form(Product3.class);
        return main(inputProduct3.render(product3Form));
    }

    //public  static  Result createProduct3(){
    //    Form<Product3> newProduct3=product3Form.bindFromRequest();
    //    if(newProduct3.hasErrors()){
    //        return main(inputProduct3.render(newProduct3));
    //    }else {
    //        product3=newProduct3.get();
    //        Product3.create(product3);
    //        return listProduct3();
    //    }
    //}

    public static Result saveProduct3(){
        Form<Product3> newProduct3 = product3Form.bindFromRequest();
        if (newProduct3.hasErrors()) {
            return main(inputProduct3.render(newProduct3));
        } else {
            product3 = newProduct3.get();
            Product3 test = Product3.finder.byId(product3.getId());
            if(test !=null){
                flash("msgError","รหัสสินค้าที่ระบุมีอยู่แล้วในระบบ กรุณากรอกใหม่");
                return main(inputProduct3.render(newProduct3));
            }else{
                Product3.create(product3);
                return listProduct3();
            }
        }
    }
    public static Result editProduct3(String id){
            product3=Product3.finder.byId(id);
            if(product3 != null){
                product3Form = Form.form(Product3.class).fill(product3);
                return main(editProduct3.render(product3Form));
            }else{
                return listProduct3();
            }
    }
    public static Result updateProduct3() {
        Form<Product3> newProduct3 = product3Form.bindFromRequest();
        if (newProduct3.hasErrors()) {
            return main(editProduct3.render(newProduct3));
        } else {
            product3 = newProduct3.get();
            Product3.update(product3);
            return listProduct3();
        }
        }

    public static Result deleteProduct3(String id){
        product3 = Product3.finder.byId(id);
        if(product3 != null){
            Product3.delete(product3);
        }
        return listProduct3();
    }



}

