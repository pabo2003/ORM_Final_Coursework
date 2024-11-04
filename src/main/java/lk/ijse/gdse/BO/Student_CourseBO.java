package lk.ijse.gdse.BO;

import lk.ijse.gdse.DTO.Student_CourseDTO;

public interface Student_CourseBO extends SuperBO{
    public boolean save(Student_CourseDTO dto) throws Exception;

    public boolean update(Student_CourseDTO dto) throws Exception;

    public boolean delete(String ID)throws Exception;
}
