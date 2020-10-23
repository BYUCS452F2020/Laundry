package service.user;

import DAO.DataAccessException;
import DAO.Database;
import DAO.MachineDAO;
import DAO.UserDAO;
import models.User;
import models.request.user.RegisterRequest;
import models.result.machine.StartMachineResult;
import models.result.user.RegisterResult;

import java.sql.Connection;

public class RegisterService {

    public RegisterService() {
    }

    public RegisterResult register(RegisterRequest request) {

        User user = request.getUser();
        Database database = new Database();
        try {
            Connection connection = database.getConnection();
            UserDAO userDao = new UserDAO(connection);
            userDao.insertUser(user);
            return new RegisterResult("Succefully Registered New User", true);
        } catch (DataAccessException e){
            return new RegisterResult("Failed Register User", false);
        }
    }
}
