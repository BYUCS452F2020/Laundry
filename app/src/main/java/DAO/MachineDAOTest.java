package DAO;

import models.Machine;
import models.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class MachineDAOTest {

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
    void insertMachine() throws Exception {

        Machine machine = new Machine("machine101", "S11", "LG", "Room101", "12:45", "13:30","Inoh123");
        Machine compare = null;

        try {
            Connection connection = db.openConnection();
            MachineDAO mDao = new MachineDAO(connection);
            mDao.insertMachine(machine);
            compare = mDao.findMachineByUserID("Inoh123");
            db.closeConnection(true);
        } catch (DataAccessException e) {
            db.closeConnection(false);
            throw new Exception("error inserting machine test");
        }
        assertEquals(compare, machine);
    }

    @Test
    void deleteMachineByUserJobID() throws Exception {

        Machine machine = new Machine("machine101", "S11", "LG", "Room101", "12:45", "13:30","Inoh123");
        Machine compare = null;

        try {
            Connection connection = db.openConnection();
            MachineDAO mDao = new MachineDAO(connection);
            mDao.insertMachine(machine);
            mDao.deleteMachineByUserJobID(machine);
            compare = mDao.findMachineByUserID("Inoh123");
            db.closeConnection(true);
        } catch (DataAccessException e) {
            db.closeConnection(false);
            throw new Exception("error deleting machine test");
        }
        assertNull(compare);
    }

    @Test
    void updateMachine() throws Exception {

        Machine machine = new Machine("machine101", "S11", "LG", "Room101", "12:45", "13:30","Inoh123");
        Machine compare = null;

        try {
            Connection connection = db.openConnection();
            MachineDAO mDao = new MachineDAO(connection);
            mDao.insertMachine(machine);
            mDao.updateMachine(new Machine("machine101", "s11", "LG", "Room111", "15:00","17:00","Inoh123"));
            compare = mDao.findMachineByUserID("Inoh123");
            db.closeConnection(true);
        } catch (DataAccessException e) {
            db.closeConnection(false);
            throw new Exception("error deleting machine test");
        }
        assertEquals(compare.getRoomID(), "Room111");


    }
}