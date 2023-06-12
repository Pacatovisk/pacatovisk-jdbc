package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;

public class ProgramDaoDepartment {

    public static void main(String[] args) {

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("===== TEST-DEPARTMENT  INSERT ====");
        Department department = new Department(null, "RH");
        departmentDao.insert(department);

        System.out.println(" \n ===== TEST-DEPARTMENT FIND BY ID ====");
        Department department1 = departmentDao.findById(1);
        System.out.println(department1);

        System.out.println(" \n ===== TEST-DEPARTMENT FIND ALL ====");
        List<Department> departmentList = departmentDao.findAll();

        for (Department dep : departmentList) {
            System.out.println(dep);
        }

        System.out.println(" \n ===== TEST-DEPARTMENT UPDATE ====");
        departmentDao.update(new Department(22, "Human Resources"));

        System.out.println(" \n ==== TEST-DEPARTMENT DELETE");
        departmentDao.deleteById(21);

    }
}
