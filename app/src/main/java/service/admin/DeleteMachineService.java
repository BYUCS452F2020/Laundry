package service.admin;

import DAO.DataAccessException;
import DAO.Database;
import DAO.MachineDAO;
import models.TableType;
import models.request.admin.DeleteMachineRequest;
import models.result.admin.DeleteResult;

import java.sql.Connection;

public class DeleteMachineService {

    public DeleteMachineService() {
    }

    public DeleteResult delete(DeleteMachineRequest request) {

        String machineId = request.getMachineId();
        Database database = new Database();
        try {
            Connection connection = database.getConnection();
            MachineDAO machineDao = new MachineDAO(connection);
            machineDao.deleteMachineById((machineId));
            return new DeleteResult("Successfully Delete Machine", true);
        } catch (DataAccessException e){
            return new DeleteResult(e.getMessage(), false);
        }
    }
}
