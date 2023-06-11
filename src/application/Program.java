package application;

import model.entities.Department;
import model.entities.Seller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Program {
    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Date data = new Date();

        Department obj = new Department(1, "books");
        System.out.println(obj);

        Seller seller = new Seller(1,"Marcelo","Marcelo@gmail.com",  new Date(),2000.0,obj);
        System.out.println(seller);

    }
}
