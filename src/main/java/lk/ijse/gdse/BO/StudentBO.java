package lk.ijse.gdse.BO;

import lk.ijse.gdse.DTO.StudentDTO;
import lk.ijse.gdse.Entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentBO extends SuperBO {
    public boolean save(StudentDTO dto) throws Exception;

    public boolean update(StudentDTO dto) throws Exception;

    public boolean delete(String ID)throws Exception;

    public String generateNextId() throws SQLException, ClassNotFoundException;
    public List<StudentDTO> getAll() throws SQLException, ClassNotFoundException;

    List<String> getIds();

    Student searchByContact(String id) throws SQLException, ClassNotFoundException;
}
