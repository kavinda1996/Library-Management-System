package service.custom;

import model.Users;
import service.SuperService;

import java.util.List;

public interface UsersBo extends SuperService {
    boolean addCustomer(Users customer);
    boolean updateCustomer(Users customer);
    Users searchCustomer(String id);
    List<Users> getAll();
    boolean deleteCustomer(String id);
}
