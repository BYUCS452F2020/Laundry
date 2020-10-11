package handlers;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import models.RequestType;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public class MachineHandler implements HttpHandler {
  private String requestType;

  public MachineHandler(String requestType) {
    this.requestType = requestType;
  }

  @Override
    public void handle(HttpExchange exchange) throws IOException {
        System.out.println(LocalTime.now() + " Received communication: machine handler/" + requestType);

        try {
            Boolean success = false;

            switch (this.requestType) {
                case RequestType.CREATE:
                  success = createMachine(exchange);
                  break;
                case RequestType.DELETE:
                  success = deleteMachine();
                  break;
                case RequestType.UPDATE:
                  success = updateMachine();
                  break;
                case RequestType.STATUS:
                  success = getMachineStatus(exchange);
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

            exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, 0);
            exchange.getResponseBody().close();
        }
    }

    /**
     * Add the machineId 
     * @param exchange
     * @return
     */
    private boolean createMachine(HttpExchange exchange) {
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

  private boolean getMachineStatus(HttpExchange exchange) {
    System.out.println(LocalTime.now() + " Get machine's status");
    return true;
  }
}
