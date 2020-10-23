package models.result.admin;

import models.result.Result;

public class EditResult extends Result {

    /**
     * Initializes a new EditResult object to represent the result
     * @param theMessage "Edit succeeded" if successful, otherwise description of error
     * @param theSuccess true if successful, otherwise false
     */
    public EditResult(String theMessage, boolean theSuccess) {
        super(theMessage, theSuccess);
    }

}
