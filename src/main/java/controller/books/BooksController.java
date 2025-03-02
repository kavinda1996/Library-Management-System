package controller.books;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Books;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BooksController implements BooksService {
    @Override
    public boolean addItem() {
        return false;
    }

    @Override
    public boolean updateItem() {
        return false;
    }

    @Override
    public boolean deleteItem() {
        return false;
    }

    @Override
    public Books searchItem(String code) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM books WHERE code=" + "'" + code + "'");
            resultSet.next();
            return new Books(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getInt(4)
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Books> getAll() {
        try {
            List<Books> itemList = new ArrayList<>();
            Connection connection = DBConnection.getInstance().getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM books");

            while (resultSet.next()) {
                boolean add = itemList.add(
                        new Books(
                        )
                );
            }
            return itemList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ObservableList<String> getItemCodes(){
        ObservableList<String> itemCodeList = FXCollections.observableArrayList();
        List<Books> itemList = getAll();
        itemList.forEach(item -> {
            itemCodeList.add(item.getCode());
        });
        return itemCodeList;
    }



//    public boolean updateStock(List<BorrowingDetail> orderDetails){
//        for (BorrowingDetail orderDetail:orderDetails){
//            boolean isUpdateStock = updateStock(orderDetail);
//            if (!isUpdateStock){
//                return false;
//            }
//        }
//        return true;
//    }
//    public boolean updateStock(BorrowingDetail orderDetail){
//        String SQL = "UPDATE item SET qtyOnHand = qtyOnHand-? WHERE code=?";
//        try {
//            Connection connection = DBConnection.getInstance().getConnection();
//            PreparedStatement psTm = connection.prepareStatement(SQL);
//            psTm.setObject(1,orderDetail.getQty());
//            psTm.setObject(2,orderDetail.getItemCode());
//            return psTm.executeUpdate()>0;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }


}
