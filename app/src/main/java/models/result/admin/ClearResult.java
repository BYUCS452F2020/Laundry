package models.result.admin;

import models.result.Result;

public class ClearResult extends Result {

    /**
     * Initializes a new ClearResult object to represent the result
     * @param theMessage "Clear succeeded" if successful, otherwise description of error
     * @param theSuccess true if successful, otherwise false
     */
    public ClearResult(String theMessage, boolean theSuccess) {
        super(theMessage, theSuccess);
    }

}
