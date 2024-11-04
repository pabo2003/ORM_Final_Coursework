package lk.ijse.gdse.BO.Impl;

import lk.ijse.gdse.BO.StudentBO;
import lk.ijse.gdse.DAO.DAOFactory;
import lk.ijse.gdse.DAO.StudentDAO;
import lk.ijse.gdse.DTO.StudentDTO;
import lk.ijse.gdse.Entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DaoType.Student);

    /*@Override
    public boolean save(StudentDTO dto) throws Exception {
        return studentDAO.save(new Student(dto.getStu_id(),dto.getStu_name(),dto.getStu_phone(),dto.getStu_email(),dto.getStu_address());

    }*/
    @Override
    public boolean save(StudentDTO dto) throws Exception {
        /*if (dto == null) {
            throw new IllegalArgumentException("StudentDTO cannot be null");
        }

        Student student = new Student();
        student.setStu_id(dto.getStu_id());
        student.setStu_name(dto.getStu_name());
        student.setStu_phone(dto.getStu_phone());
        student.setStu_email(dto.getStu_email());
        student.setStu_address(dto.getStu_address());

        return studentDAO.save(student);*/
//        return studentDAO.save(new Student(dto.getStu_id(), dto.getStu_name(), dto.getStu_phone(), dto.getStu_email(), dto.getStu_address()));
        Student student = new Student(dto.getStu_id(), dto.getStu_name(), dto.getStu_phone(), dto.getStu_email(),dto.getStu_address());
        return studentDAO.save(student);
    }


    @Override
    public boolean update(StudentDTO dto) throws Exception {
        return studentDAO.update(new Student(dto.getStu_id(), dto.getStu_name(), dto.getStu_phone(), dto.getStu_email(), dto.getStu_address()));
    }

    @Override
    public boolean delete(String ID) throws Exception {
        return studentDAO.delete(ID);
    }

    @Override
    public List<StudentDTO> getAll() throws SQLException, ClassNotFoundException {
        List<Student> students = studentDAO.getAll();
        List<StudentDTO> dtos = new ArrayList<>();
        for (Student student : students) {
            dtos.add(new StudentDTO(student.getStu_id(),student.getStu_name(),student.getStu_phone(),student.getStu_email(),student.getStu_address()));
        }
        return dtos;
    }
}
