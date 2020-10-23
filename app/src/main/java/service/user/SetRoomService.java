package service.user;

import DAO.DataAccessException;
import DAO.Database;
import DAO.UserDAO;
import models.User;
import models.request.user.SetRoomRequest;
import models.result.user.RegisterResult;
import models.result.user.SetRoomResult;

import java.sql.Connection;

public class SetRoomService {

    public SetRoomService() {
    }

    public SetRoomResult set(SetRoomRequest request) {

        String userId = request.getUserId();
        String roomId = request.getRoomId();
        Database database = new Database();
        try {
            Connection connection = database.getConnection();
            UserDAO userDao = new UserDAO(connection);
            userDao.updatePreferedRoom(userId, roomId);
            return new SetRoomResult("Succefully Updated Preferred Room", true);
        } catch (DataAccessException e){
            return new SetRoomResult("Failed to update preferred room", false);
        }
    }
}
