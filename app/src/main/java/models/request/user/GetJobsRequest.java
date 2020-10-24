package models.request.user;

public class GetJobsRequest {

  public String username;

  public GetJobsRequest(String username) {
    this.username = username;
  }

  public String getUsername() {
    return username;
  }
}
