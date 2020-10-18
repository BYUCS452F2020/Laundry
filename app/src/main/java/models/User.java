package models;

public class User {

    String userID;
    String userName;
    String preferredRoomID;
    String phoneNumber;
    String email;

    public User(String userID, String userName, String preferredRoomID, String phoneNumber, String email) {
        this.userID = userID;
        this.userName = userName;
        this.preferredRoomID = preferredRoomID;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPreferredRoomID() {
        return preferredRoomID;
    }

    public void setPreferredRoomID(String preferredRoomID) {
        this.preferredRoomID = preferredRoomID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof User) {
            User oUser = (User) o;
            return oUser.getUserID().equals(getUserID()) &&
                    oUser.getUserName().equals(getUserName()) &&
                    oUser.getPreferredRoomID().equals(getPreferredRoomID()) &&
                    oUser.getPhoneNumber().equals(getPhoneNumber()) &&
                    oUser.getEmail().equals(getEmail());
        }
        else {
            return false;
        }
    }
}
