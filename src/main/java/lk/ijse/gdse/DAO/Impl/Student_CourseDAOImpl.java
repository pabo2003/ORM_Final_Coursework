package lk.ijse.gdse.DAO.Impl;

import lk.ijse.gdse.DAO.Student_CourseDAO;
import lk.ijse.gdse.Entity.Student_Course;

import java.sql.SQLException;
import java.util.List;

public class Student_CourseDAOImpl implements Student_CourseDAO {
    @Override
    public boolean save(Student_Course entity) throws Exception {
        return false;
    }

    @Override
    public boolean update(Student_Course entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String ID) throws Exception {
        return false;
    }

    @Override
    public List<Student_Course> getAll() throws SQLException, ClassNotFoundException {
        return List.of();
    }

    @Override
    public Student_Course searchByIdCustomer(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
