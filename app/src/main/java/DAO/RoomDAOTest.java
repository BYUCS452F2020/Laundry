package DAO;

import models.Room;
import models.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class RoomDAOTest {

    private Database db;

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

    @Test
    void insertRoom() throws Exception{

        Room room1 = new Room("Room101", "BYU_Laundry", "1000N 1000W");
        Room compare = null;

        try {
            Connection connection = db.openConnection();
            RoomDAO rDao = new RoomDAO(connection);
            rDao.insertRoom(room1);
            compare = rDao.findRoomByID("Room101");
            db.closeConnection(true);

        } catch (DataAccessException e) {
            db.closeConnection(false);
            throw new Exception("error inserting room test");
        }
        assertEquals(compare, room1);
    }

    @Test
    void deleteRoom() throws Exception {

        Room room1 = new Room("Room101", "BYU_Laundry", "1000N 1000W");
        Room compare = null;

        try {
            Connection connection = db.openConnection();
            RoomDAO rDao = new RoomDAO(connection);
            rDao.insertRoom(room1);
            rDao.deleteRoom(room1);
            compare = rDao.findRoomByID("Room101");
            db.closeConnection(true);

        } catch (DataAccessException e) {
            db.closeConnection(false);
            throw new Exception("error deleting room test");
        }
        assertNull(compare);
    }

    @Test
    void updateRoom() throws Exception {

        Room room1 = new Room("Room101", "BYU_Laundry", "1000N 1000W");
        Room compare = null;

        try {
            Connection connection = db.openConnection();
            RoomDAO rDao = new RoomDAO(connection);
            rDao.insertRoom(room1);
            rDao.updateRoom(new Room("Room101", "Branbury", "1768N 450W"));
            compare = rDao.findRoomByID("Room101");
            db.closeConnection(true);

        } catch (DataAccessException e) {
            db.closeConnection(false);
            throw new Exception("error updating room test");
        }
        assertEquals(compare.getRoomName(), "Branbury");
    }
}