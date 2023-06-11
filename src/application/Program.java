package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("====== TEST 1: seller findById =======");
        Seller seller = sellerDao.findById(1);
        System.out.println(seller);

        System.out.println("\n====== TEST 2: seller findByDepartment =======");
        Department department = new Department(1, "ELETRONICS");

        List<Seller> sellerList = sellerDao.findByDepartment(department);

        for (Seller x : sellerList) {
            System.out.println(x);
        }

        System.out.println("\n====== TEST 3: seller findAll =======");
        List<Seller> sellerList2 = sellerDao.findAll();

        for (Seller x : sellerList2) {
            System.out.println(x);
        }

        System.out.println("\n====== TEST 4: seller insert =======");
        Seller newSeller = new Seller(null, "Marcelo", "marcelo@gmail.com", new Date(), 4000.0, new Department(1, "Eletronics"));
        sellerDao.insert(newSeller);

        System.out.println("\n====== TEST 5: seller update =======");
        Seller newSellerUpdate = new Seller(1, "Bob Brown", "bob_bob@gmail.com", new Date(), 4000.0, new Department(1, "Eletronics"));
        sellerDao.update(newSellerUpdate);

        System.out.println("\n====== TEST 6: seller delete =======");
        sellerDao.deleteById(5);
    }
}
