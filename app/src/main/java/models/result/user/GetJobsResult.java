package models.result.user;

import models.object.Job;
import models.result.Result;

import java.util.List;

public class GetJobsResult extends Result {

    private List<Job> jobList;

    public GetJobsResult(String theMessage, boolean theSuccess, List<Job> jobList) {
        super(theMessage, theSuccess);
        this.jobList = jobList;
    }

}
