package service.machine;

import DAO.DataAccessException;
import DAO.Database;
import DAO.MachineDAO;
import models.Machine;
import models.request.machine.EndMachineRequest;
import models.result.machine.EndMachineResult;

import java.sql.Connection;

public class EndMachineService {
    public EndMachineService() {
    }

    public EndMachineResult end(EndMachineRequest request) {

        Machine machine = request.getMachine();
        Database database = new Database();
        try {
            Connection connection = database.getConnection();
            MachineDAO machineDao = new MachineDAO(connection);
            machineDao.updateMachine(machine);
            return new EndMachineResult("Succefully Ended Job!", true);
        } catch (DataAccessException e){
            return new EndMachineResult("Failed to End Job!", false);
        }
    }
}
