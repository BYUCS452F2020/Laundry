package DAO;

import java.sql.Connection;

public class MachineDAO {

    private Connection connection;

    public MachineDAO(Connection connection) { this.connection = connection; }
    public MachineDAO() {}

    public void setConnection(Connection connection) { this.connection = connection; }
}
