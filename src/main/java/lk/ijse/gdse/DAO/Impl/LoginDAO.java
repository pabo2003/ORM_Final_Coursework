package lk.ijse.gdse.DAO.Impl;

import lk.ijse.gdse.DAO.CrudDAO;
import lk.ijse.gdse.Entity.Login;

public interface LoginDAO extends CrudDAO<Login> {


    Login getLastLogin();
}
