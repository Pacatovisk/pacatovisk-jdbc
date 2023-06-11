package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        Department obj = new Department(1, "books");
        System.out.println(obj);

        Seller seller = sellerDao.findById(1);
        System.out.println(seller);

    }
}
