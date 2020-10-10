package models.object;

public class Machine {

    private int MachineId;
    private String MachineName;
    private String MachineBrand;
    private int runtimeMinutes;
    private int roomId;
    private double jobStartTime; //Could be an int?
    private int jobUserId;
    private double jobFinishTime;

    public Machine(int machineId, String machineName, String machineBrand, int runtimeMinutes, int roomId, double jobStartTime, int jobUserId, double jobFinishTime) {
        MachineId = machineId;
        MachineName = machineName;
        MachineBrand = machineBrand;
        this.runtimeMinutes = runtimeMinutes;
        this.roomId = roomId;
        this.jobStartTime = jobStartTime;
        this.jobUserId = jobUserId;
        this.jobFinishTime = jobFinishTime;
    }

    public int getMachineId() {
        return MachineId;
    }

    public void setMachineId(int machineId) {
        MachineId = machineId;
    }

    public String getMachineName() {
        return MachineName;
    }

    public void setMachineName(String machineName) {
        MachineName = machineName;
    }

    public String getMachineBrand() {
        return MachineBrand;
    }

    public void setMachineBrand(String machineBrand) {
        MachineBrand = machineBrand;
    }

    public int getRuntimeMinutes() {
        return runtimeMinutes;
    }

    public void setRuntimeMinutes(int runtimeMinutes) {
        this.runtimeMinutes = runtimeMinutes;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public double getJobStartTime() {
        return jobStartTime;
    }

    public void setJobStartTime(double jobStartTime) {
        this.jobStartTime = jobStartTime;
    }

    public int getJobUserId() {
        return jobUserId;
    }

    public void setJobUserId(int jobUserId) {
        this.jobUserId = jobUserId;
    }

    public double getJobFinishTime() {
        return jobFinishTime;
    }

    public void setJobFinishTime(double jobFinishTime) {
        this.jobFinishTime = jobFinishTime;
    }
}
