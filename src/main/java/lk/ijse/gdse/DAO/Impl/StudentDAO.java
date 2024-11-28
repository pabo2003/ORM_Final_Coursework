package lk.ijse.gdse.DAO.Impl;

import lk.ijse.gdse.DAO.CrudDAO;
import lk.ijse.gdse.Entity.Student;

import java.sql.SQLException;

public interface StudentDAO extends CrudDAO<Student> {
    public Student searchByContact(String id) throws SQLException, ClassNotFoundException;
    }
