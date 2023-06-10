package application;

import db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ProgramUpdate {
    public static void main(String[] args) {

        try {
            Connection connection = DB.getConnection();
            PreparedStatement ps =
                    connection
                            .prepareStatement(
                                    "UPDATE seller " +
                                            "SET BaseSalary = BaseSalary + ? " +
                                            "WHERE (DepartmentId = ? )"
                                    , Statement.RETURN_GENERATED_KEYS);

            ps.setDouble(1, 200.0);
            ps.setInt(2, 1);

            int rowsAffected = ps.executeUpdate();

            System.out.println("Done! Rows affected: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
