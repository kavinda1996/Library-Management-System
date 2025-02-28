package service.custom.impl;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Users;
import repository.DaoFactory;
import repository.custom.UsersDao;
import service.custom.UsersBo;
import util.DaoType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersBoImpl implements UsersBo {
    UsersDao customerDao = DaoFactory.getInstance().getDaoType(DaoType.users);

    @Override
    public boolean addCustomer(Users customer) {
      return  customerDao.save(customer);
    }

    @Override
    public boolean updateCustomer(Users customer) {
        return false;
    }

    @Override
    public Users searchCustomer(String id) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM users WHERE id=" +"'"+ id+"'");
            resultSet.next();
            return new Users(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Users> getAll() {
        ArrayList<Users> customerArrayList = new ArrayList<>();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            while (resultSet.next()) {
                System.out.println(resultSet.getString(3));
                Users customer = new Users(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                );
                customerArrayList.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return customerArrayList;
    }

    public ObservableList<String> getCustomerIds(){
        List<Users> customerList = getAll();
        ObservableList<String> customerIdList = FXCollections.observableArrayList();

        customerList.forEach(customer -> {
            customerIdList.add(customer.getId());
        });

        return customerIdList;

    }
    @Override
    public boolean deleteCustomer(String id) {
        return false;
    }
}
