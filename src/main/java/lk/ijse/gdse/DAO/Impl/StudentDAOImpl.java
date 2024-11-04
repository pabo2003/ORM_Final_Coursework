package lk.ijse.gdse.DAO.Impl;

import lk.ijse.gdse.DAO.StudentDAO;
import lk.ijse.gdse.Entity.Course;
import lk.ijse.gdse.Entity.Student;
import lk.ijse.gdse.Entity.User;
import lk.ijse.gdse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public boolean save(Student entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction tx = session.beginTransaction();
        session.save(entity);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Student entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction tx = session.beginTransaction();
        session.update(entity);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String ID) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction tx = session.beginTransaction();
        Student student = new Student();
        student.setStu_id(ID);
        session.delete(student);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public List<Student> getAll() throws SQLException, ClassNotFoundException {
        List<Student> all = new ArrayList<>();
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        all = session.createQuery("from Student").list();
        transaction.commit();
        session.close();
        return all;
    }

    @Override
    public Student searchByIdCustomer(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
