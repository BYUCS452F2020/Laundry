package DAO;

import models.Room;
import models.User;

import java.sql.*;

public class RoomDAO {

    private Connection connection;

    public RoomDAO(Connection connection) { this.connection = connection; }
    public RoomDAO() {}

    public void setConnection(Connection connection) { this.connection = connection; }

    public void insertRoom(Room room) throws DataAccessException {

        String sql = "insert into Room (RoomID, RoomName, RoomAddress)" +
                " VALUES(?,?,?)";
        try {
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, room.getRoomID());
            stmt.setString(2, room.getRoomName());
            stmt.setString(3, room.getRoomAddress());

            stmt.executeUpdate();
        }
        catch (SQLException e) {
            throw new DataAccessException("error while inserting room");
        }
    }

    public Room findRoomByID(String roomID) throws DataAccessException {

        Room room;
        try {
            PreparedStatement stmt = null;
            ResultSet rs = null;

            String sql = "select * from Room where RoomID = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, roomID);
            rs = stmt.executeQuery();

            if (rs.next()) {
                room = new Room(rs.getString("RoomID"), rs.getString("RoomName"), rs.getString("RoomAddress"));
                return room;
            }

        } catch (SQLException e) {
            throw new DataAccessException("error while finding room");
        }
        return null;
    }

    public void deleteRoom (Room room) throws DataAccessException {
        try {
            Statement stmt = null;
            stmt = connection.createStatement();
            stmt.executeUpdate("delete from Room where RoomID = '" + room.getRoomID() + "'");
        }
        catch (SQLException e) {
            throw new DataAccessException("error while deleting room");
        }
    }

    public void updateRoom(Room room) throws DataAccessException {

        String sql = "update Room set RoomName=?, RoomAddress=? where RoomID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, room.getRoomName());
            stmt.setString(2, room.getRoomAddress());
            stmt.setString(3, room.getRoomID());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new DataAccessException("error while updating room");
        }
    }




}
