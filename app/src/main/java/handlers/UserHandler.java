package handlers;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import models.RequestType;
import models.object.Job;
import models.request.user.GetJobsRequest;
import models.request.user.RegisterRequest;
import models.result.user.GetJobsResult;
import models.result.user.RegisterResult;
import service.user.GetJobsService;
import service.user.RegisterService;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserHandler implements HttpHandler {
  private Map<String, String> exchangeParameters;
  private String type;

  public UserHandler(String type) {
    exchangeParameters = new HashMap<>();
    this.type = type;
  }

  @Override
  public void handle(HttpExchange exchange) throws IOException {
    System.out.println(LocalTime.now() + " Received communication: user handler/" + type);

    try {
      Boolean success = false;

      switch (this.type) {
        case RequestType.CREATE:
          success = createUser();
          break;
        case RequestType.DELETE:
          success = deleteUser();
          break;
        case RequestType.UPDATE:
          success = updateUser();
          break;
        case RequestType.JOBS:
          success = getJobs(exchange);
          break;
      }

      // Send http response
      int responseCode = success ? HttpURLConnection.HTTP_OK : HttpURLConnection.HTTP_BAD_REQUEST;
      exchange.sendResponseHeaders(responseCode, 0);
      exchange.getResponseBody().close();

      exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, 0);
      exchange.getResponseBody().close();
    } catch (IOException e) {
      System.out.println(LocalTime.now() + " Exception: " + e.toString());
    }
  }

  private Boolean getJobs(HttpExchange exchange) {
    System.out.println(LocalTime.now() + " Getting jobs");
    String username = exchangeParameters.get("username");
    GetJobsRequest request = new GetJobsRequest(username);
    GetJobsResult result = new GetJobsService().getJobs(request);

    if (!result.getSuccess()) {
      System.out.println(result.getMessage());
    } else {
      StringBuilder sb = new StringBuilder();

      for (int i = 0; i < result.jobList.size(); i++) {
        Job job = result.jobList.get(i);
        sb.append("Job #" + i + ": start: " + job.getStartTime() + ", end: " + job.getEndTime());
      }

      OutputStream os = exchange.getResponseBody();
      PrintStream printStream = new PrintStream(os);
      printStream.print(sb.toString());
    }

    return result.getSuccess();
  }

  private boolean createUser() {
    System.out.println(LocalTime.now() + " Creating user");

    String userId = exchangeParameters.get("userid");
    String username = exchangeParameters.get("username");
    String preferredRoomId = exchangeParameters.get("preferredRoomId");
    String email = exchangeParameters.get("email");
    String phone = exchangeParameters.get("phone");

    RegisterRequest request = new RegisterRequest(username, preferredRoomId, email, phone, userId);
    RegisterResult result = new RegisterService().register(request);

    if (!result.getSuccess()) {
      System.out.println(result.getMessage());
    }

    return result.getSuccess();
  }

  private boolean deleteUser() {
    System.out.println(LocalTime.now() + " Deleting user");
    return true;
  }

  private boolean updateUser() {
    System.out.println(LocalTime.now() + " Update user");
    return true;
  }

  private void getExchangeParameters(HttpExchange exchange) {
    // Get headers
    Headers headers = exchange.getRequestHeaders();
    for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
      StringBuilder sb = new StringBuilder();
      for (String str : entry.getValue()) {
        sb.append(str);
      }
      exchangeParameters.put(entry.getKey(), sb.toString());
    }
  }
}
