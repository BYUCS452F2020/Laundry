package models.request.admin;

public class GetMachinesRequest {

    private String roomId;

    public GetMachinesRequest(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomId() {
        return roomId;
    }
}
