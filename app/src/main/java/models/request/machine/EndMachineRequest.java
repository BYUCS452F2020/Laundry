package models.request.machine;

import models.Machine;

/**
 * Machine Notifying the Server that a job has finished
 */
public class EndMachineRequest {

    private Machine machine;

    public EndMachineRequest(Machine machine) {
        this.machine = machine;
    }

    public Machine getMachine() {
        return machine;
    }
}
