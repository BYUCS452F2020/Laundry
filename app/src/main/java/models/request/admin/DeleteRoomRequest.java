package models.request.admin;

public class DeleteRoomRequest {

    private String roomId;

    public DeleteRoomRequest(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomId() {
        return roomId;
    }
}
