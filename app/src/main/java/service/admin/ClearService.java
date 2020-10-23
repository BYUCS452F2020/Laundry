package service.admin;

import DAO.*;
import models.TableType;
import models.request.admin.ClearRequest;
import models.result.admin.ClearResult;

import java.sql.Connection;
import java.sql.SQLException;

public class ClearService {

    public ClearService() {
    }

    public ClearResult clear(ClearRequest request) {

        TableType table = request.getTable();
        Database database = new Database();
        try {
            Connection connection = database.getConnection();

            switch (table) {
                case ROOM:
                    RoomDAO roomDao = new RoomDAO(connection);
                    roomDao.clearRooms();
                    //Not Placing a break here because if rooms are cleared, machines should be too
                case MACHINE:
                    MachineDAO machineDao = new MachineDAO(connection);
                    machineDao.clearMachines();
                    break;

                case USER:
                    UserDAO userDao = new UserDAO(connection);
                    userDao.clearUsers();
            }

            return new ClearResult(String.format("Successfully Cleared Table: %s", table.toString()), true);
        }
        catch (DataAccessException e) {
            return new ClearResult(e.getMessage(), false);
        }

    }
}
