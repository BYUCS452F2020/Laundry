package DAO;

import models.Machine;
import models.User;
import models.object.Job;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Machine> getMachinesByRoom(String roomID) throws DataAccessException {

        ArrayList<Machine> roomMachines = new ArrayList<Machine>();
        try {
            PreparedStatement stmt = null;
            ResultSet rs = null;

            String sql = "select * from Machine where RoomID = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, roomID);
            rs = stmt.executeQuery();

            while (rs.next()) {
                roomMachines.add(new Machine(rs.getString("MachineID"), rs.getString("MachineName"), rs.getString("Brand"), rs.getString("RoomID"), rs.getString("JobStartTime"), rs.getString("JobFinishTime"), rs.getString("JobUserID")));
            }
            if (roomMachines.size() != 0) {
                return roomMachines;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new DataAccessException("Error Retrieving Machines from Database");
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

    public void deleteMachineById (String machineId) throws DataAccessException {
        try {
            Statement stmt = null;
            stmt = connection.createStatement();
            stmt.executeUpdate(String.format("DELETE FROM Machine WHERE MachineId = '%s'", machineId));
        }
        catch (SQLException e){
            throw new DataAccessException("Error while deleting machine");
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

    public void startMachine(String machineId, String userId) throws DataAccessException {
        String sql1 = "SELECT * FROM Machine WHERE MachineID=?";
        String sql2 = "update Machine set JobStartTime=?, JobFinishTime=?, JobUserID=? where MachineID=?";

        try {
            PreparedStatement stmt1 = connection.prepareStatement(sql1);
            stmt1.setString(1, machineId);
            ResultSet rs = null;
            Machine machine = null;
            rs = stmt1.executeQuery();

            if (rs.next()) {
                 machine = new Machine(rs.getString("MachineID"), rs.getString("MachineName"), rs.getString("Brand"), rs.getString("RoomID"), rs.getString("JobStartTime"), rs.getString("JobFinishTime"), rs.getString("JobUserID"));
            } else {
                throw new DataAccessException("Error while starting machine! Machine Not Found.");
            }

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            PreparedStatement stmt2 = connection.prepareStatement(sql2);
            stmt2.setString(1, timestamp.toString());
            stmt2.setString(2, "Need to implement how long a machine will take");
            stmt2.setString(3, userId);
            stmt2.executeUpdate();


        } catch (SQLException e) {
            throw new DataAccessException("Error while starting machine!");
        }
    }

    public void clearMachines() throws DataAccessException {
        String sql = "DELETE FROM Machine";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DataAccessException("Error while clearing Machines");
        }
    }


    public List<Machine> findMachinesByUserID(String userID) throws DataAccessException {

        List<Machine> machineList = new ArrayList<>();
        try {
            PreparedStatement stmt = null;
            ResultSet rs = null;

            String sql = "select * from Machine where JobUserID = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, userID);
            rs = stmt.executeQuery();

            while (rs.next()) {
                machineList.add(new Machine(rs.getString("MachineID"), rs.getString("MachineName"), rs.getString("Brand"), rs.getString("RoomID"), rs.getString("JobStartTime"), rs.getString("JobFinishTime"), rs.getString("JobUserID")));
            }
            return machineList;

        } catch (SQLException e) {
            throw new DataAccessException("error while finding machine");
        }
    }
}
