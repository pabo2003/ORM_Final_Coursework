package lk.ijse.gdse.BO;

import lk.ijse.gdse.BO.Impl.*;
import lk.ijse.gdse.Entity.Payment;
import lk.ijse.gdse.Entity.User;

public class BOFactory {
    private static BOFactory boFactory;

    private  BOFactory(){}

    public static BOFactory getBoFactory(){
        return (boFactory == null)? boFactory = new BOFactory() : boFactory;
    }

    public enum BOType{
        USER,STUDENT,COURSE,STUDENT_REGISTER,PAYMENT
    }

    public SuperBO getBO(BOType type){
        switch (type){
            case USER:
                return new UserBOImpl();
            case STUDENT:
                return (SuperBO) new StudentBOImpl();
            case COURSE:
                return  new PaymentBOImpl();
            case PAYMENT:
                return (SuperBO) new CourseBOImpl();
            case STUDENT_REGISTER:
                return (SuperBO) new StudentRegisterBOImpl();
            default:
                return null;

        }
    }
}
