package service.admin;

import DAO.DataAccessException;
import DAO.Database;
import DAO.RoomDAO;
import models.request.admin.DeleteRoomRequest;
import models.result.admin.DeleteResult;

import java.sql.Connection;

public class DeleteRoomService {

    public DeleteRoomService() {
    }

    public DeleteResult delete(DeleteRoomRequest request) {

        String roomId = request.getRoomId();
        Database database = new Database();
        try {
            Connection connection = database.getConnection();
            RoomDAO roomDao = new RoomDAO(connection);
            roomDao.deleteRoom(roomId);
            return new DeleteResult("Successfully Deleted Room", true);
        } catch (DataAccessException e){
            return new DeleteResult(e.getMessage(), false);
        }
    }
}
