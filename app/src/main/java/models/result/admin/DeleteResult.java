package models.result.admin;

import models.result.Result;

public class DeleteResult extends Result {

    /**
     * Initializes a new DeleteResult object to represent the result
     * @param theMessage "Delete succeeded" if successful, otherwise description of error
     * @param theSuccess true if successful, otherwise false
     */
    public DeleteResult(String theMessage, boolean theSuccess) {
        super(theMessage, theSuccess);
    }

}
