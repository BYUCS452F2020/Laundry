package models.request.admin;

import models.object.Room;

public class EditRoomRequest {

    private Room room;

    public EditRoomRequest(Room room) {
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }
}
