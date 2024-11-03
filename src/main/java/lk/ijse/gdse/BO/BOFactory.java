package lk.ijse.gdse.BO;

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
            case PAYMENT ->
            {
                return (SuperBO) new Payment();
            }
            case USER -> {
                return (SuperBO) new User();
            }
            default -> {
                return null;
            }
        }
    }
}
