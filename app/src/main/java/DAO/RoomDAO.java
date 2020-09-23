package DAO;

import java.sql.Connection;

public class RoomDAO {

    private Connection connection;

    public RoomDAO(Connection connection) { this.connection = connection; }
    public RoomDAO() {}

    public void setConnection(Connection connection) { this.connection = connection; }
}
