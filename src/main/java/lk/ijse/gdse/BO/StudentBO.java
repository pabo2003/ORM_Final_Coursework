package lk.ijse.gdse.BO;

import lk.ijse.gdse.DTO.StudentDTO;
import lk.ijse.gdse.DTO.UserDTO;

import java.util.List;

public interface StudentBO extends SuperBO {
    public boolean save(StudentDTO dto) throws Exception;

    public boolean update(StudentDTO dto) throws Exception;

    public boolean delete(String ID)throws Exception;
    public List<StudentDTO> getAll() throws Exception;
}
