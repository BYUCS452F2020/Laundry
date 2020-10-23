package models.result.admin;

import models.object.Machine;
import models.result.Result;

import java.util.List;

public class GetMachinesResult extends Result {

    List<Machine> machineList;

    public GetMachinesResult(String theMessage, boolean theSuccess, List<Machine> machineList) {
        super(theMessage, theSuccess);
        this.machineList = machineList;
    }
}
