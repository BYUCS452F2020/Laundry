package DAO;

import models.User;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {

    private Database db;
    private User user1;

    @BeforeEach
    public void setUp() throws Exception {
        db = new Database();
        db.openConnection();
        db.createTables();
        db.closeConnection(true);
    }

    @AfterEach
    public void tearDown() throws Exception {
        db.openConnection();
        db.clearTables();
        db.closeConnection(true);
    }

    @org.junit.jupiter.api.Test
    public void insertUser() throws Exception {

        user1 = new User("Inoh123", "Inoh Pak", "Room123", "801", "asdf@gmail.com");
        User compare = null;

        try {
            Connection connection = db.openConnection();
            UserDAO uDao = new UserDAO(connection);
            uDao.insertUser(user1);
            //uDao.insertUser(new User("inoh2", "asdf", "123123", "456","@@@@"));
            compare = uDao.findUserByID("Inoh123");
            //uDao.updateUser(new User("Inoh123", "Inchul Pak", "Room405", "888", "pic@gmail.com"));
            db.closeConnection(true);

        } catch (DataAccessException e) {
            db.closeConnection(false);
            throw new Exception("error inserting user test");
        }
        assertEquals(compare, user1);
    }


    @org.junit.jupiter.api.Test
    void testUpdateUser() throws Exception {
        user1 = new User("Inoh123", "Inoh Pak", "Room123", "801", "asdf@gmail.com");
        User compare = null;
        try {
            Connection connection = db.openConnection();
            UserDAO uDao = new UserDAO(connection);
            uDao.insertUser(user1);
            uDao.updateUser(new User("Inoh123", "Inchul Pak", "Room405", "888", "pic@gmail.com"));
            compare = uDao.findUserByID("Inoh123");
            db.closeConnection(true);

        } catch (DataAccessException e) {
            db.closeConnection(false);
            throw new Exception("error inserting user test");
        }
        assertEquals(compare.getUserName(), "Inchul Pak");
    }

    @org.junit.jupiter.api.Test
    void deleteUser() throws Exception {
        user1 = new User("Inoh123", "Inoh Pak", "Room123", "801", "asdf@gmail.com");
        User compare = null;
        try {
            Connection connection = db.openConnection();
            UserDAO uDao = new UserDAO(connection);
            uDao.insertUser(user1);
            uDao.deleteUser(user1);
            compare = uDao.findUserByID("Inoh123");
            db.closeConnection(true);

        } catch (DataAccessException e) {
            db.closeConnection(false);
            throw new Exception("error inserting user test");
        }
        assertNull(compare);
    }
}