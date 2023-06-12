package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {

    protected Connection connection;

    public DepartmentDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Department obj) {

        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement("INSERT INTO department (name) VALUES (?)");

            ps.setString(1, obj.getName());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Done! Rows Affected: " + rowsAffected);
            } else {
                throw new DbException("Nenhuma linha inserida!");
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(ps);
        }


    }

    @Override
    public void update(Department obj) {

        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement("UPDATE department SET name = ? WHERE id = ?");
            ps.setString(1, obj.getName());
            ps.setInt(2, obj.getId());
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Done! Rows affected: " + rowsAffected);
            } else {
                throw new DbException("None rows affected!");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(ps);
        }
    }

    @Override
    public void deleteById(Integer id) {

        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("DELETE FROM department WHERE id = ?");
            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Done! Rows affected: " + rowsAffected);
            } else {
                throw new DbException("No lines have been deleted!");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(ps);
        }

    }

    @Override
    public Department findById(Integer id) {

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection
                    .prepareStatement("SELECT * FROM department d WHERE d.id = ? ");

            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                return new Department(rs.getInt("Id"), rs.getString("Name"));
            } else {
                throw new DbException("Nenhum registro foi encontrado com o id: " + id);
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(ps);
            DB.closeResultSet(rs);
        }

    }

    @Override
    public List<Department> findAll() {

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement("SELECT * FROM department d ORDER BY d.id");

            rs = ps.executeQuery();

            List<Department> departments = new ArrayList<>();

            while (rs.next()) {
                departments.add(new Department(rs.getInt("Id"), rs.getString("Name")));
            }

            if (!departments.isEmpty()) {
                return departments;
            } else {
                throw new DbException("Nenhum departamento foi encontrado!");
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(ps);
            DB.closeResultSet(rs);
        }
    }
}
