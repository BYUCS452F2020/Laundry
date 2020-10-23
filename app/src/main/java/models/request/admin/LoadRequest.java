package models.request.admin;

import models.object.Machine;
import models.object.Room;
import models.object.User;

import java.util.List;

/**
 * Load data into the database -- Rooms, Machines, and Users in lists
 */
public class LoadRequest {

    private List<Room> roomList;
    private List<Machine> machineList;
    private List<User> userList;

    public LoadRequest(List<Room> roomList, List<Machine> machineList, List<User> userList) {
        this.roomList = roomList;
        this.machineList = machineList;
        this.userList = userList;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public List<Machine> getMachineList() {
        return machineList;
    }

    public List<User> getUserList() {
        return userList;
    }
}
