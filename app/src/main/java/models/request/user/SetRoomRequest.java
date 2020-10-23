package models.request.user;

public class SetRoomRequest {

    public String roomId;
    public String userId;

    public SetRoomRequest(String roomId, String userId) {
        this.roomId = roomId;
        this.userId = userId;
    }

    public String getRoomId() {
        return roomId;
    }

    public String getUserId() {return userId;}
}
