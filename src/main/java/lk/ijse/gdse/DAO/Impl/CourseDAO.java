package lk.ijse.gdse.DAO.Impl;

import lk.ijse.gdse.DAO.CrudDAO;
import lk.ijse.gdse.Entity.Course;

import java.sql.SQLException;

public interface CourseDAO extends CrudDAO<Course> {
    Course searchByName(String id) throws SQLException, ClassNotFoundException;
}
