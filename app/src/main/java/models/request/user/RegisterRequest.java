package models.request.user;

import models.object.User;

public class RegisterRequest {

    private String username;
    private String preferedRoomID;
    private String email;
    private String phone;

    public RegisterRequest(String username, String preferedRoomID, String email, String phone) {
        this.username = username;
        this.preferedRoomID = preferedRoomID;
        this.email = email;
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public String getPreferedRoomID() {
        return preferedRoomID;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
