package DAO;

import java.sql.Connection;

public class UserDAO {

    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }
    public UserDAO() {}

    public void setConnection(Connection connection) {this.connection = connection;}



}
