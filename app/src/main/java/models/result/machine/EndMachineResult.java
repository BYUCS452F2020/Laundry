package models.result.machine;

import models.result.Result;

public class EndMachineResult extends Result {

    /**
     * Initializes a new EndMachineResult object to represent the result
     * @param theMessage "End succeeded" if successful, otherwise description of error
     * @param theSuccess true if successful, otherwise false
     */
    public EndMachineResult(String theMessage, boolean theSuccess) {
        super(theMessage, theSuccess);
    }

}
