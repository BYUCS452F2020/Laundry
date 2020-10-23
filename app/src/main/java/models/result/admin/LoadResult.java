package models.result.admin;

import models.result.Result;

public class LoadResult extends Result {

    /**
     * Initializes a new LoadResult object to represent the result. Format is essentially the same for both successes
     * and failure
     * @param theMessage "Successfully added X users, Y machines, and Z rooms to the database" if successful, otherwise description of error
     * @param theSuccess true if successful, otherwise false
     */
    public LoadResult(String theMessage, boolean theSuccess) {
        super(theMessage, theSuccess);
    }
}
