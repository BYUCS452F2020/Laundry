package models.object;

import java.util.ArrayList;

public class Room {

    private String roomId;
    private String roomName;
    private String roomAddress;
    private double roomLat;
    private double roomLon;
    private ArrayList<Integer> machineList;
    private int washerCount;
    private int dryerCount;

    public Room(String roomId, String roomName, String roomAddress, double roomLat, double roomLon, ArrayList<Integer> machineList, int washerCount, int dryerCount) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomAddress = roomAddress;
        this.roomLat = roomLat;
        this.roomLon = roomLon;
        this.machineList = machineList;
        this.washerCount = washerCount;
        this.dryerCount = dryerCount;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomAddress() {
        return roomAddress;
    }

    public void setRoomAddress(String roomAddress) {
        this.roomAddress = roomAddress;
    }

    public double getRoomLat() {
        return roomLat;
    }

    public void setRoomLat(double roomLat) {
        this.roomLat = roomLat;
    }

    public double getRoomLon() {
        return roomLon;
    }

    public void setRoomLon(double roomLon) {
        this.roomLon = roomLon;
    }

    public ArrayList<Integer> getMachineList() {
        return machineList;
    }

    public void setMachineList(ArrayList<Integer> machineList) {
        this.machineList = machineList;
    }

    public int getWasherCount() {
        return washerCount;
    }

    public void setWasherCount(int washerCount) {
        this.washerCount = washerCount;
    }

    public int getDryerCount() {
        return dryerCount;
    }

    public void setDryerCount(int dryerCount) {
        this.dryerCount = dryerCount;
    }
}
