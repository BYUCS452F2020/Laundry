package service.admin;

import DAO.DataAccessException;
import DAO.Database;
import DAO.MachineDAO;
import DAO.RoomDAO;
import models.Machine;
import models.Room;
import models.request.admin.EditRoomRequest;
import models.result.admin.EditResult;

import java.sql.Connection;

public class EditRoomService {

    public EditRoomService() {

    }

    public EditResult edit(EditRoomRequest request) {

        Room room = request.getRoom();
        Database database = new Database();
        try {
            Connection connection = database.getConnection();
            RoomDAO roomDao = new RoomDAO(connection);
            roomDao.updateRoom(room);
            return new EditResult("Successfully Updated Room", true);
        } catch (DataAccessException e){
            return new EditResult(e.getMessage(), false);
        }
    }
}
