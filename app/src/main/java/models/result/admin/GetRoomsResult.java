package models.result.admin;

import models.object.Room;
import models.result.Result;

import java.util.List;

public class GetRoomsResult extends Result {

    private List<Room> roomList;

    public GetRoomsResult(String theMessage, boolean theSuccess, List<Room> roomList) {
        super(theMessage, theSuccess);
        this.roomList = roomList;
    }
}
