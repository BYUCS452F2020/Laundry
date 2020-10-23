package service.machine;

import DAO.DataAccessException;
import DAO.Database;
import DAO.MachineDAO;
import models.request.machine.StartMachineRequest;
import models.result.machine.EndMachineResult;
import models.result.machine.StartMachineResult;

import java.sql.Connection;

public class StartMachineService {

    public StartMachineService() {

    }

    public StartMachineResult start(StartMachineRequest request) {

        String machineId = request.getMachineId();
        String userId = request.getUsername();
        Database database = new Database();
        try {
            Connection connection = database.getConnection();
            MachineDAO machineDao = new MachineDAO(connection);
            machineDao.startMachine(machineId, userId);
            return new StartMachineResult("Succefully Started Job!", true);
        } catch (DataAccessException e){
            return new StartMachineResult("Failed to Start Job!", false);
        }
    }
}
