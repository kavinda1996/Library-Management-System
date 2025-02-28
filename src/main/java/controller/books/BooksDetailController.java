package controller.books;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BooksDetailController {

    public boolean addItem(String code, String description, double unitPrice, int qtyOnHand) {
        String SQL = "INSERT INTO item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)";
        Connection connection = null;
        PreparedStatement psTm = null;

        try {
            connection = DBConnection.getInstance().getConnection();
            psTm = connection.prepareStatement(SQL);

            psTm.setString(1, code);
            psTm.setString(2, description);
            psTm.setDouble(3, unitPrice);
            psTm.setInt(4, qtyOnHand);

            int result = psTm.executeUpdate(); // Execute query & check result

            if (result > 0) {
                System.out.println("✅ Item added successfully!"); // Success message
                return true;
            } else {
                System.out.println("❌ Failed to add item."); // Failure message
                return false;
            }

        } catch (SQLException e) {
            System.out.println("❌ Error adding item: " + e.getMessage());
            return false;
        } finally {
            try {
                if (psTm != null) psTm.close();
            } catch (SQLException closeEx) {
                closeEx.printStackTrace();
            }
        }
    }
}
