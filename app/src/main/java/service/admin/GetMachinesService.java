package service.admin;

import DAO.DataAccessException;
import DAO.Database;
import DAO.MachineDAO;
import models.Machine;
import models.request.admin.GetMachinesRequest;
import models.result.admin.EditResult;
import models.result.admin.GetMachinesResult;

import java.sql.Connection;
import java.util.List;

public class GetMachinesService {

    public GetMachinesService() {

    }

    public GetMachinesResult getMachines(GetMachinesRequest request){

        String roomID = request.getRoomId();
        Database database = new Database();
        try {
            Connection connection = database.getConnection();
            MachineDAO machineDao = new MachineDAO(connection);
            List<Machine> machineList = machineDao.getMachinesByRoom(roomID);
            if (machineList != null){
                return new GetMachinesResult("Successfully Retrieved Machines", true, machineList);
            } else {
                return new GetMachinesResult("No Machines Found for that Room ID!", false, null);
            }
        } catch (DataAccessException e){
            return new GetMachinesResult(e.getMessage(), false, null);
        }
    }
}
