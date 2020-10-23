package models.request.admin;

public class DeleteMachineRequest {

    private String machineId;

    public DeleteMachineRequest(String machineId) {
        this.machineId = machineId;
    }

    public String getMachineId() {
        return machineId;
    }
}
