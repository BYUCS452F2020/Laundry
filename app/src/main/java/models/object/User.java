package models.object;

import java.util.ArrayList;

public class User {

    private String username;
    private String email;
    private int preferredRoomId;
    private int userId;
    private ArrayList<Integer> currentJobMachineIdList;

    public User(String username, String email, int preferredRoomId, int userId, ArrayList<Integer> currentJobMachineIdList) {
        this.username = username;
        this.email = email;
        this.preferredRoomId = preferredRoomId;
        this.userId = userId;
        this.currentJobMachineIdList = currentJobMachineIdList;
    }

    public ArrayList<Integer> getCurrentJobMachineIdList() {
        return currentJobMachineIdList;
    }

    public void setCurrentJobMachineIdList(ArrayList<Integer> currentJobMachineIdList) {
        this.currentJobMachineIdList = currentJobMachineIdList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPreferredRoomId() {
        return preferredRoomId;
    }

    public void setPreferredRoomId(int preferredRoomId) {
        this.preferredRoomId = preferredRoomId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
