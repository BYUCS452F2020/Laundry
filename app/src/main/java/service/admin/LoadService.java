package service.admin;

import DAO.*;
import models.Machine;
import models.Room;
import models.User;
import models.request.admin.LoadRequest;
import models.result.admin.LoadResult;

import java.sql.Connection;
import java.util.List;

public class LoadService {

    public LoadService() {
    }

    public LoadResult load(LoadRequest request) {

        List<Machine> machines = request.getMachineList();
        List<Room> rooms = request.getRoomList();
        List<User> users = request.getUserList();
        Database database = new Database();
        try {
            Connection connection = database.getConnection();
            MachineDAO machineDao = new MachineDAO(connection);
            RoomDAO roomDao = new RoomDAO(connection);
            UserDAO userDao = new UserDAO(connection);

            for (Machine m: machines) {
                machineDao.insertMachine(m);
            }
            for (User u: users) {
                userDao.insertUser(u);
            }
            for (Room r: rooms) {
                roomDao.insertRoom(r);
            }

            return new LoadResult(String.format("Successfully added %d users, %d rooms, and %d machines",
                    users.size(), rooms.size(), machines.size()), true);

        } catch (DataAccessException e) {
            return new LoadResult(e.getMessage(), false);
        }

    }
}
