package lk.ijse.gdse.DAO.Impl;

import lk.ijse.gdse.DAO.CrudDAO;
import lk.ijse.gdse.Entity.User;

import java.util.List;

public interface UserDAO extends CrudDAO<User> {
    public User searchByUsername(String username);

    List<String> getUserIds();
}
