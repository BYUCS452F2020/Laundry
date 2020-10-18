package DAO;

import models.Machine;
import models.User;

import java.sql.*;

public class MachineDAO {

    private Connection connection;

    public MachineDAO(Connection connection) { this.connection = connection; }
    public MachineDAO() {}

    public void setConnection(Connection connection) { this.connection = connection; }

    public void insertMachine(Machine machine) throws DataAccessException {
        String sql = "insert into Machine (MachineID, MachineName, Brand, RoomID, JobStartTime, JobFinishTime, JobUserID)" +
                " VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, machine.getMachineID());
            stmt.setString(2, machine.getMachineName());
            stmt.setString(3, machine.getMachineBrand());
            stmt.setString(4, machine.getRoomID());
            stmt.setString(5, machine.getJobStartTime());
            stmt.setString(6, machine.getJobFinishTime());
            stmt.setString(7, machine.getJobUserID());

            stmt.executeUpdate();
        }
        catch (SQLException e) {
            throw new DataAccessException("error while inserting machine");
        }
    }

    public Machine findMachineByUserID(String userID) throws DataAccessException {

        Machine machine;
        try {
            PreparedStatement stmt = null;
            ResultSet rs = null;

            String sql = "select * from Machine where JobUserID = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, userID);
            rs = stmt.executeQuery();

            if (rs.next()) {
                machine = new Machine(rs.getString("MachineID"), rs.getString("MachineName"), rs.getString("Brand"), rs.getString("RoomID"), rs.getString("JobStartTime"), rs.getString("JobFinishTime"), rs.getString("JobUserID"));
                return machine;
            }

        } catch (SQLException e) {
            throw new DataAccessException("error while finding machine");
        }
        return null;
    }

    public void deleteMachineByUserJobID (Machine machine) throws DataAccessException {
        try {
            Statement stmt = null;
            stmt = connection.createStatement();
            stmt.executeUpdate("delete from Machine where JobUserID = '" + machine.getJobUserID() + "'");
        }
        catch (SQLException e) {
            throw new DataAccessException("error while deleting machine");
        }
    }

    public void updateMachine (Machine machine) throws DataAccessException {
        String sql = "update Machine set RoomID=?, JobStartTime=?, JobFinishTime=? where JobUserID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, machine.getRoomID());
            stmt.setString(2, machine.getJobStartTime());
            stmt.setString(3, machine.getJobFinishTime());
            stmt.setString(4, machine.getJobUserID());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new DataAccessException("error while updating machine");
        }
    }


}
