package models;

public class Room {

    String roomID;
    String roomName;
    String roomAddress;

    public Room(String roomID, String roomName, String roomAddress) {
        this.roomID = roomID;
        this.roomName = roomName;
        this.roomAddress = roomAddress;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
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

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof Room) {
            Room oRoom = (Room) o;
            return oRoom.getRoomID().equals(getRoomID()) &&
                    oRoom.getRoomName().equals(getRoomName()) &&
                    oRoom.getRoomAddress().equals(getRoomAddress());
        }
        else {
            return false;
        }
    }



}
