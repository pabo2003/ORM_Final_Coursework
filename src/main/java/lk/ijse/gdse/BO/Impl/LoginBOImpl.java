package lk.ijse.gdse.BO.Impl;

import lk.ijse.gdse.BO.LoginBO;
import lk.ijse.gdse.DAO.DAOFactory;
import lk.ijse.gdse.DAO.Impl.LoginDAO;
import lk.ijse.gdse.DTO.LoginDTO;
import lk.ijse.gdse.Entity.Login;

import java.sql.SQLException;

public class LoginBOImpl implements LoginBO {
    LoginDAO loginDAO = (LoginDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DaoType.Login);

    @Override
    public boolean save(LoginDTO dto) throws Exception {
        return loginDAO.save(new Login(dto.getLogin(),dto.getUserID(),dto.getDate()));
    }

    @Override
    public String generateNextId() throws SQLException, ClassNotFoundException {
        return loginDAO.generateNextId();
    }
}
