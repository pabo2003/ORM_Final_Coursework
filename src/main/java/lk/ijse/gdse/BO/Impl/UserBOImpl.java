package lk.ijse.gdse.BO.Impl;

import lk.ijse.gdse.BO.UserBO;
import lk.ijse.gdse.DAO.DAOFactory;
import lk.ijse.gdse.DAO.UserDAO;
import lk.ijse.gdse.DTO.UserDTO;
import lk.ijse.gdse.Entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserBOImpl implements UserBO {
  UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DaoType.User);
    @Override
    public boolean save(UserDTO dto) throws Exception {
        return userDAO.save(new User(dto.getUser_id(),dto.getUsername(),dto.getAddress(),dto.getUser_phone(),dto.getUser_email(),dto.getPosition(),dto.getPassword()));
    }

    @Override
    public boolean update(UserDTO dto) throws Exception {
        return userDAO.update(new User(dto.getUser_id(),dto.getUsername(),dto.getAddress(),dto.getUser_phone(),dto.getUser_email(),dto.getPosition(),dto.getPassword()));
    }

    @Override
    public boolean delete(String ID) throws Exception {
       return userDAO.delete(ID);
    }

    @Override
    public List<UserDTO> getAll() throws SQLException, ClassNotFoundException {
        List<User> users = userDAO.getAll();
        List<UserDTO> dtos = new ArrayList<>();
        for (User user : users) {
            dtos.add(new UserDTO(user.getUser_id(),user.getUsername(),user.getAddress(),user.getUser_phone(),user.getUser_email(),user.getPosition(),user.getPassword()));
        }
        return dtos;
    }

    @Override
    public UserDTO searchByIdCustomer(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
