package lk.ijse.gdse.BO;

import lk.ijse.gdse.DTO.LoginDTO;

import java.sql.SQLException;

public interface LoginBO extends SuperBO{
    public boolean save(LoginDTO dto) throws Exception;

    String generateNextId() throws SQLException, ClassNotFoundException;
}
