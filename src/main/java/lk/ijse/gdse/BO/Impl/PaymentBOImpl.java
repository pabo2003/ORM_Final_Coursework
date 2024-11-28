package lk.ijse.gdse.BO.Impl;

import lk.ijse.gdse.BO.PaymentBO;
import lk.ijse.gdse.DAO.DAOFactory;
import lk.ijse.gdse.DAO.Impl.PaymentDAO;
import lk.ijse.gdse.DTO.CourseDTO;
import lk.ijse.gdse.DTO.PaymentDTO;
import lk.ijse.gdse.DTO.StudentDTO;
import lk.ijse.gdse.DTO.Student_CourseDTO;
import lk.ijse.gdse.Entity.Course;
import lk.ijse.gdse.Entity.Payment;
import lk.ijse.gdse.Entity.Student;
import lk.ijse.gdse.Entity.Student_Course;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentBOImpl implements PaymentBO {
PaymentDAO paymentDAO = (PaymentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DaoType.Payment);
    @Override
    public boolean save(PaymentDTO dto) throws Exception {
        return paymentDAO.save(new Payment(
                dto.getPay_id(),
                dto.getPay_date(),
                dto.getPay_amount(),
                new Student_Course(
                dto.getStudentCourse().getStudent_course_id(),
                new Student(),
                new Course(),
                dto.getStudentCourse().getRegistration_date(),
                new ArrayList<>()
                )));
    }

    @Override
    public boolean update(PaymentDTO dto) throws Exception {
        return paymentDAO.update(new Payment(
                dto.getPay_id(),
                dto.getPay_date(),
                dto.getPay_amount(),
                new Student_Course(
                        dto.getStudentCourse().getStudent_course_id(),
                        new Student(),
                        new Course(),
                        dto.getStudentCourse().getRegistration_date(),
                        new ArrayList<>()
                )));
    }

    @Override
    public boolean delete(String ID) throws Exception {
        return false;
    }
    @Override
    public Payment searchById(String id) throws SQLException, ClassNotFoundException {
        return paymentDAO.searchByID(id);
    }

    public String generateNextId() throws SQLException, ClassNotFoundException {
        return paymentDAO.generateNextId();
    }

    @Override
    public List<PaymentDTO> getAll() throws SQLException, ClassNotFoundException {
        List<Payment> payment = paymentDAO.getAll();
        List<PaymentDTO> dto = new ArrayList<>();
        for (Payment payment1 : payment) {
            dto.add(new PaymentDTO(payment1.getPay_id(),payment1.getPay_date(),payment1.getPay_amount(),new Student_CourseDTO(payment1.getStudent_course().getStudent_course_id(),new StudentDTO(),new CourseDTO(),payment1.getStudent_course().getRegistration_date())));
        }
        return dto;
    }
}
