package service.user;

import DAO.DataAccessException;
import DAO.Database;
import DAO.MachineDAO;
import DAO.UserDAO;
import models.Machine;
import models.User;
import models.object.Job;
import models.request.user.GetJobsRequest;
import models.result.user.GetJobsResult;
import models.result.user.RegisterResult;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class GetJobsService {

  public GetJobsService() {
  }

  public GetJobsResult getJobs(GetJobsRequest request) {

    List<Machine> machineList = null;
    List<Job> jobList = new ArrayList<>();
    String username = request.getUsername();
    Database database = new Database();
    try {
      Connection connection = database.getConnection();
      MachineDAO machineDao = new MachineDAO(connection);
      machineList = machineDao.findMachinesByUserID(username);

      if (machineList.size() != 0) {
        for (Machine m : machineList) {
          jobList.add(new Job(m.getJobUserID(), m.getJobStartTime(), m.getJobFinishTime()));
        }
        return new GetJobsResult("Successfully retrieved jobs", true, jobList);
      } else {
        return new GetJobsResult("No Jobs found for this user!", false, null);
      }
    } catch (DataAccessException e) {
      return new GetJobsResult("Failed to retrieve jobs", false, null);
    }

  }
}
