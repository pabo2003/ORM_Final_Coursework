package lk.ijse.gdse.DAO.Impl;

import lk.ijse.gdse.DAO.PaymentDAO;
import lk.ijse.gdse.Entity.Payment;

import java.sql.SQLException;
import java.util.List;

public class PaymentDAOImpl implements PaymentDAO {
    @Override
    public boolean save(Payment entity) throws Exception {
        return false;
    }

    @Override
    public boolean update(Payment entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String ID) throws Exception {
        return false;
    }

    @Override
    public List<Payment> getAll() throws SQLException, ClassNotFoundException {
        return List.of();
    }

    @Override
    public Payment searchByIdCustomer(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
