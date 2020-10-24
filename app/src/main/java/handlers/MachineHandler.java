package handlers;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import models.RequestType;
import models.request.machine.StartMachineRequest;
import models.result.machine.StartMachineResult;
import service.machine.StartMachineService;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MachineHandler implements HttpHandler {
  private Map<String, String> exchangeParameters;
  private String requestType;

  public MachineHandler(String requestType) {
    this.requestType = requestType;
    exchangeParameters = new HashMap<>();
  }

  @Override
  public void handle(HttpExchange exchange) throws IOException {
    System.out.println(LocalTime.now() + " Received communication: machine handler/" + requestType);

    try {
      getExchangeParameters(exchange);

      Boolean success = false;

      switch (this.requestType) {
        case RequestType.START:
          success = startMachine();
          break;
        case RequestType.CREATE:
          success = createMachine();
          break;
        case RequestType.DELETE:
          success = deleteMachine();
          break;
        case RequestType.UPDATE:
          success = updateMachine();
          break;
        case RequestType.STATUS:
          success = getMachineStatus();
          break;
        default:
          System.out.println("Request type " + requestType + " not recognized");
      }

      // Send http response
      int responseCode = success ? HttpURLConnection.HTTP_OK : HttpURLConnection.HTTP_BAD_REQUEST;
      exchange.sendResponseHeaders(responseCode, 0);
      exchange.getResponseBody().close();
    } catch (Exception e) {
      System.out.println(LocalTime.now() + " Exception: " + e.toString());
      e.printStackTrace();
      exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, 0);
      exchange.getResponseBody().close();
    }
  }

  private Boolean startMachine() {
    System.out.println("Starting machine");

    String machineId = exchangeParameters.get("machineId");
    String username = exchangeParameters.get("username");
    StartMachineRequest request = new StartMachineRequest(machineId, username);
    StartMachineResult result = new StartMachineService().start(request);

    if (!result.getSuccess()) {
      System.out.println(result.getMessage());
    }

    return result.getSuccess();
  }

  /**
   * Add the machineId
   * 
   * @param exchange
   * @return
   */
  private boolean createMachine() {
    System.out.println(LocalTime.now() + " Creating machine");
    return true;
  }

  private boolean deleteMachine() {
    System.out.println(LocalTime.now() + " Deleting machine");
    return true;
  }

  private boolean updateMachine() {
    System.out.println(LocalTime.now() + " Update machine");
    return true;
  }

  private boolean getMachineStatus() {
    System.out.println(LocalTime.now() + " Get machine's status");
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
