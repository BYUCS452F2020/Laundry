package models.request.user;

public class CheckRoomRequest {

    public String username;

    public CheckRoomRequest(String username) {
        this.username = username;
    }

    public String getUsername(){
        return username;
    }
}
