package models.result.machine;

import models.result.Result;

public class StartMachineResult extends Result {

    /**
     * Initializes a new StartMachineResult object to represent the result
     * @param theMessage "Start succeeded" if successful, otherwise description of error
     * @param theSuccess true if successful, otherwise false
     */

    public StartMachineResult(String theMessage, boolean theSuccess) {
        super(theMessage, theSuccess);
    }
}
