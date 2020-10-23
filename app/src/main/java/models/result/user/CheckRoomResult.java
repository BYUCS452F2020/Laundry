package models.result.user;

import models.object.Machine;
import models.result.Result;

import java.util.List;

public class CheckRoomResult extends Result {
    List<Machine> machineList;

    public CheckRoomResult(String theMessage, boolean theSuccess, List<Machine> machineList) {
        super(theMessage, theSuccess);
        this.machineList = machineList;
    }
}
