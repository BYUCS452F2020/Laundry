package models.request.machine;

/**
 * Machine Notifying the Server that a job has finished
 */
public class EndMachineRequest {

    private String machineId;

    public EndMachineRequest(String machineId) {
        this.machineId = machineId;
    }

    public String getMachineId() {
        return machineId;
    }
}
