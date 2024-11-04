package lk.ijse.gdse.DAO;

import lk.ijse.gdse.DAO.Impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){
    }

    public static DAOFactory getDaoFactory(){
        return (daoFactory == null)?daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOType{
        USER,STUDENT,PAYMENT,COURSE,STUDENT_REGISTER
    }

    public SuperDAO getDAO(DAOType daoType){
        switch (daoType) {
            case USER:
                return (SuperDAO) new UserDAOImpl();
            case STUDENT:
                return (SuperDAO) new StudentDAOImpl();
            case PAYMENT:
                return new PaymentDAOImpl();
            case COURSE:
                return (SuperDAO) new CourseDAOImpl();
            case STUDENT_REGISTER:
                return (SuperDAO) new StudentRegisterDAOImpl();
            default:
                return null;
        }
    }
}
