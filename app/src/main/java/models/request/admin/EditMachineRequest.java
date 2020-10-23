package models.request.admin;

import models.Machine;

public class EditMachineRequest {

    private Machine machine;

    public EditMachineRequest(Machine machine) {
        this.machine = machine;
    }

    public Machine getMachine() {
        return machine;
    }
}
