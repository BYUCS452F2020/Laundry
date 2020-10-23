package models.request.machine;

/**
 * Machine notifying the server that a job has started
 */
public class StartMachineRequest {

    private String machineId;
    private String username;

    public StartMachineRequest(String machineId, String username) {
        this.machineId = machineId;
        this.username = username;
    }

    public String getMachineId() {
        return machineId;
    }

    public String getUsername() {
        return username;
    }
}
