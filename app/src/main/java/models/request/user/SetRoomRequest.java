package models.request.user;

public class SetRoomRequest {

    public String roomId;

    public SetRoomRequest(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomId() {
        return roomId;
    }
}
