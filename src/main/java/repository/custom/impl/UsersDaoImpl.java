package repository.custom.impl;

import db.DBConnection;
import model.Users;
import repository.custom.UsersDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UsersDaoImpl implements UsersDao {
    @Override
    public boolean save(Users entity) {
        String SQL = "INSERT INTO users VALUES(?,?,?,?)";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement psTm = connection.prepareStatement(SQL);
            psTm.setObject(1,entity.getId());
            psTm.setObject(2,entity.getName());
            psTm.setObject(3,entity.getAddress());
            psTm.setObject(4,entity.getEmail());
            return psTm.executeUpdate()>0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean update(String s, Users entity) {
        return false;
    }

    @Override
    public Users search(String s) {
        return null;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public List<Users> getAll() {
        return null;
    }
}
