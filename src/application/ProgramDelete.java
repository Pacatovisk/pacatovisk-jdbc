package application;

import db.DB;
import db.DbIntegrityException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProgramDelete {

    public static void main(String[] args)  {
        PreparedStatement ps = null;

        try {
            Connection connection = DB.getConnection();
             ps = connection
                    .prepareStatement("DELETE FROM department WHERE id = ?");

            ps.setInt(1, 1);

            int rowsAffected = ps.executeUpdate();

            System.out.println("Rows affected: " + rowsAffected);
        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        } finally {
            DB.closeStatement(ps);
            DB.closeConnection();
        }
    }
}
