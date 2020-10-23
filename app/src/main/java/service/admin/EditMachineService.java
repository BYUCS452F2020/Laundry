package service.admin;

import DAO.DataAccessException;
import DAO.Database;
import DAO.MachineDAO;
import models.Machine;
import models.request.admin.EditMachineRequest;
import models.result.admin.DeleteResult;
import models.result.admin.EditResult;

import java.sql.Connection;

public class EditMachineService {

    public EditMachineService() {
    }

    public EditResult edit(EditMachineRequest request) {
        Machine machine = request.getMachine();
        Database database = new Database();
        try {
            Connection connection = database.getConnection();
            MachineDAO machineDao = new MachineDAO(connection);
            machineDao.updateMachine(machine);
            return new EditResult("Successfully Updated Machine", true);
        } catch (DataAccessException e){
            return new EditResult(e.getMessage(), false);
        }
    }

}
