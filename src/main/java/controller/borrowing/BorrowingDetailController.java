package controller.borrowing;

import db.DBConnection;
import model.BorrowingDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BorrowingDetailController {
    public boolean addOrderDetail(List<BorrowingDetail> orderDetails){
        for (BorrowingDetail orderDetail:orderDetails){
            boolean isOrderDetailAdd = addOrderDetail(orderDetail);
            if (!isOrderDetailAdd){
                return false;
            }
        }
        return true;

    }

    public  boolean addOrderDetail(BorrowingDetail orderDetail){
        String SQL = "INSERT INTO orderdetail VALUES(?,?,?,?)";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement psTm = connection.prepareStatement(SQL);
            psTm.setObject(1,orderDetail.getOrderId());
            psTm.setObject(2,orderDetail.getItemCode());
            psTm.setObject(3,orderDetail.getQty());
            psTm.setObject(4,orderDetail.getUnitPrice());
           return psTm.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
