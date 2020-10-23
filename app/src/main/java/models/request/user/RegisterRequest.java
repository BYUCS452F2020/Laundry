package models.request.user;

import models.User;

public class RegisterRequest {

    private String userId;
    private String username;
    private String preferedRoomID;
    private String email;
    private String phone;

    public RegisterRequest(String username, String preferedRoomID, String email, String phone, String userId) {
        this.username = username;
        this.preferedRoomID = preferedRoomID;
        this.email = email;
        this.phone = phone;
        this.userId = userId;
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

    public String getUserId() {
        return userId;
    }

    public User getUser() {
        return new User(userId, username, preferedRoomID, phone, email);
    }
}
