package models.result;

/**
 * Result class provides a base class for all other result types. Results always contain a boolean success indicator and
 * a message, so it makes sense to use these fields as a super class.
 */
public class Result {

    private String message;
    private Boolean success;

    /**
     * Creates an empty result object
     */
    public Result() {
        message = "";
        success = true;
    }

    /**
     * Creates a new result object with initialized fields. Most error results will use this constructor
     * @param theMessage the message to be included, usually an error message describing why the request failed
     * @param theSuccess the success state of the result, true if the result succeeded, false if failure
     */
    public Result(String theMessage, boolean theSuccess){
        message = theMessage;
        success = theSuccess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
