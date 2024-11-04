package lk.ijse.gdse.BO;

import lk.ijse.gdse.DTO.UserDTO;

import java.sql.SQLException;
import java.util.List;

public interface UserBO extends SuperBO {
    public boolean save(UserDTO dto) throws Exception;

    public boolean update(UserDTO dto) throws Exception;

    public boolean delete(String ID)throws Exception;

    public List<UserDTO> getAll() throws SQLException, ClassNotFoundException;

    UserDTO searchByIdCustomer(String id) throws SQLException, ClassNotFoundException;

}
