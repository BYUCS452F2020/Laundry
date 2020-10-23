package models;

public class Machine {

    String machineID;
    String machineName;
    String machineBrand;
    String roomID;
    String jobStartTime;
    String jobFinishTime;
    String jobUserID;

    public Machine(String machineID, String machineName, String machineBrand, String roomID, String jobStartTime, String jobFinishTime, String jobUserID) {
        this.machineID = machineID;
        this.machineName = machineName;
        this.machineBrand = machineBrand;
        this.roomID = roomID;
        this.jobStartTime = jobStartTime;
        this.jobFinishTime = jobFinishTime;
        this.jobUserID = jobUserID;
    }

    public String getMachineID() {
        return machineID;
    }

    public void setMachineID(String machineID) {
        this.machineID = machineID;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getMachineBrand() {
        return machineBrand;
    }

    public void setMachineBrand(String machineBrand) {
        this.machineBrand = machineBrand;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getJobStartTime() {
        return jobStartTime;
    }

    public void setJobStartTime(String jobStartTime) {
        this.jobStartTime = jobStartTime;
    }

    public String getJobFinishTime() {
        return jobFinishTime;
    }

    public void setJobFinishTime(String jobFinishTime) {
        this.jobFinishTime = jobFinishTime;
    }

    public String getJobUserID() {
        return jobUserID;
    }

    public void setJobUserID(String jobUserID) {
        this.jobUserID = jobUserID;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof Machine) {
            Machine oMachine = (Machine) o;
            return oMachine.getMachineID().equals(getMachineID()) &&
                    oMachine.getMachineName().equals(getMachineName()) &&
                    oMachine.getMachineBrand().equals(getMachineBrand()) &&
                    oMachine.getRoomID().equals(getRoomID()) &&
                    oMachine.getJobStartTime().equals(getJobStartTime()) &&
                    oMachine.getJobFinishTime().equals(getJobFinishTime()) &&
                    oMachine.getJobUserID().equals(getJobUserID());
        }
        else {
            return false;
        }
    }
}
