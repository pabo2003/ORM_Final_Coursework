package lk.ijse.gdse.BO.Impl;

import lk.ijse.gdse.BO.BOFactory;
import lk.ijse.gdse.BO.PaymentBO;
import lk.ijse.gdse.BO.Student_CourseBO;
import lk.ijse.gdse.DTO.StudentRegisterPlaceDTO;
import lk.ijse.gdse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentRegisterBOImpl {

    public static boolean StudentRegisterPlace(StudentRegisterPlaceDTO SR) {
        PaymentBO paymentBO = (PaymentBO) BOFactory.getBoFactory().getBo(BOFactory.BoType.Payment);
        Student_CourseBO studentCourseBO = (Student_CourseBO) BOFactory.getBoFactory().getBo(BOFactory.BoType.Student_Course);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            boolean isStudentRegister_SC = studentCourseBO.save(SR.getStudent_course());
            if (isStudentRegister_SC) {
                boolean isPay = paymentBO.save(SR.getStudent_payment());
                if (isPay) {
                    transaction.commit();
                    return true;
                }
            }
            if (transaction != null) transaction.rollback();
            return false;

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }
}
