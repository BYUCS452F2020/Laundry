package DAO;

import models.User;

import java.sql.*;

public class UserDAO {

    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }
    public UserDAO() {}

    public void setConnection(Connection connection) {this.connection = connection;}

    public void insertUser(User user) throws DataAccessException {

        String sql = "insert into User (UserID, Username, PreferredRoomID, PhoneNumber, Email)" +
                " VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, user.getUserID());
            stmt.setString(2, user.getUserName());
            stmt.setString(3, user.getPreferredRoomID());
            stmt.setString(4, user.getPhoneNumber());
            stmt.setString(5, user.getEmail());

            stmt.executeUpdate();
        }
        catch (SQLException e) {
            throw new DataAccessException("error while inserting user");
        }
    }

    public User findUserByID(String userID) throws DataAccessException {

        User user;
        try {
            PreparedStatement stmt = null;
            ResultSet rs = null;

            String sql = "select * from User where UserID = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, userID);
            rs = stmt.executeQuery();

            if (rs.next()) {
               user = new User(rs.getString("UserID"), rs.getString("Username"), rs.getString("PreferredRoomID"), rs.getString("PhoneNumber"), rs.getString("Email"));
               return user;
            }

        } catch (SQLException e) {
            throw new DataAccessException("error while finding user");
        }
        return null;
    }

    public void deleteUser(User user) throws DataAccessException {
        try {
            Statement stmt = null;
            stmt = connection.createStatement();
            stmt.executeUpdate("delete from User where UserID = '" + user.getUserID() + "'");
        }
        catch (SQLException e) {
            throw new DataAccessException("error while deleting user");
        }

    }

    public void updateUser(User user) throws DataAccessException {

        String sql = "update User set Username=?, PreferredRoomID=?, PhoneNumber=?, Email=? where UserID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getPreferredRoomID());
            stmt.setString(3, user.getPhoneNumber());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getUserID());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new DataAccessException("error while updating user");
        }
    }


}
