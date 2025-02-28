package controller.borrowing;

import controller.books.BooksController;
import db.DBConnection;
import model.Borrowing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BorrowingController {
    public boolean palaceOrder(Borrowing order) throws SQLException {
        Connection connection=DBConnection.getInstance().getConnection();
        String SQL = "INSERT INTO users VALUES(?,?,?)";
        try {
            connection.setAutoCommit(false);
            PreparedStatement psTm = connection.prepareStatement(SQL);
            psTm.setObject(1, order.getId());
            psTm.setObject(2, order.getDate());
            psTm.setObject(3, order.getCustomerId());
            Boolean isOrderAdd = psTm.executeUpdate() > 0;
            if (isOrderAdd) {
                boolean isOrderDetailAdd = new BorrowingDetailController().addOrderDetail(order.getOrderDetails());
                if (isOrderDetailAdd) {
                    boolean isUpdateStock = new BooksController().updateStock(order.getOrderDetails());
                    if (isUpdateStock){
                        connection.commit();
                        return true;
                    }
                }
            }
        }finally {
            connection.setAutoCommit(true);
        }
        connection.rollback();
        return false;
    }
}
