package controllers;

import models.Product;
import models.Register;
import play.*;
import play.api.templates.Html;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

    public static Product pro1 = new Product("C001","NARS","Concealer Matte", "Concealer", 500, 10);
    public static Product pro2 = new Product("L001","MAC", "Matte Lipstick","Lipstick", 850, 10);
    public static Product pro3 = new Product("E001","TARTE", "Eyeshadow Palette","Eyeshadow", 1400, 10);
    public static Product pro4 = new Product("E002","ZOEVA", "Eyeshadow Palette","Eyeshadow", 600, 10);
    public static Product pro5 = new Product("B001","CLINIQUE", "Blush on Hot Pink","Blushon", 1000, 10);
    public static Product pro6 = new Product("L002","KAT VON D"," Liquid Lipstick","Lipstick", 900, 10);

    public static Register register;
    public static Product product;

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

    public static Result product_form() { return main(product_from.render());}


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
        String id,type,name,detail;
        double price;
        int amount;

        id = myForm1.get("id");
        type = myForm1.get("type");
        name = myForm1.get("name");
        detail = myForm1.get("detail");
        price = Double.parseDouble(myForm1.get("price"));
        amount = Integer.parseInt(myForm1.get("amount"));

        product =new Product(id,type,name,detail,price,amount);

        return main(product_show.render(product));
    }



}