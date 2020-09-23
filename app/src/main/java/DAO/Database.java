package DAO;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private Connection connection;
    private UserDAO userDAO;
    private RoomDAO roomDAO;
    private MachineDAO machineDAO;

    public Database() {
        userDAO = new UserDAO();
        roomDAO = new RoomDAO();
        machineDAO = new MachineDAO();
    }

    public Connection openConnection() throws DataAccessException {

        try {
            final String CONNECTION_URL = "jdbc:sqlite:laundry.sqlite";
            connection = DriverManager.getConnection(CONNECTION_URL);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataAccessException("Unable to open connection to database");
        }
        return connection;
    }

    public void setConnection() throws DataAccessException {
        try {
            final String CONNECTION_URL = "jdbc:sqlite:laundry.sqlite";
            connection = DriverManager.getConnection(CONNECTION_URL);
            userDAO.setConnection(connection);
            roomDAO.setConnection(connection);
            machineDAO.setConnection(connection);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataAccessException("Unable to set connection");
        }
    }

    public void closeConnection(Boolean commit) throws DataAccessException {
        try {
            if (commit) {
                connection.commit();
            }
            else {
                connection.rollback();
            }
            connection.close();
            connection = null;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataAccessException("Unable to close database connection");
        }
    }

    public Connection getConnection() throws DataAccessException {
        if (connection == null) {
            return openConnection();
        }
        else {
            return connection;
        }
    }

    public void createTables() throws DataAccessException {
        try (Statement stmt = connection.createStatement()) {
            String sql1 = "create table if not exists Room " +
                    "(" +
                    "RoomID text not null unique, " +
                    "RoomName text not null, " +
                    "RoomAddress text not null, " +
                    "Latitude float not null, " +
                    "Longitude float not null, " +
                    "WasherCount int not null, " +
                    "DryerCount int not null, " +
                    "primary key (RoomID) " +
                    ")";
            String sql2 = "create table if not exists Machine " +
                    "(" +
                    "MachineID text not null unique, " +
                    "MachineName text not null, " +
                    "Brand text not null, " +
                    "Runtime int not null, " +
                    "RoomID text not null, " +
                    "JobStartTime text not null, " +
                    "JobFinishTime text not null," +
                    "JobUsername text not null, " +
                    "primary key (MachineID), " +
                    "foreign key (JobUsername) references User(Username), " +
                    "foreign key (RoomID) references Room(RoomID) " +
                    ")";
            String sql3 = "create table if not exists User " +
                    "(" +
                    "Username text not null unique, " +
                    "PreferredRoomID text not null, " +
                    "PhoneNumber text not null, " +
                    "Email text not null, " +
                    "primary key (Username) " +
                    ")";
            stmt.executeUpdate(sql1);
            stmt.executeUpdate(sql2);
            stmt.executeUpdate(sql3);

        } catch (SQLException e) {
            throw new DataAccessException("Error while creating tables");
        }
    }

    public void clearTables() throws DataAccessException {
        try (Statement stmt = connection.createStatement()) {
            String sql1 = "drop table if exists Room";
            String sql2 = "drop table if exists User";
            String sql3 = "drop table if exists Machine";
            stmt.executeUpdate(sql1);
            stmt.executeUpdate(sql2);
            stmt.executeUpdate(sql3);
        } catch (SQLException e) {
            throw new DataAccessException("Error while clearing tables");
        }
    }


}

















