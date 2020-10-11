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

public class RoomHandler implements HttpHandler {

  private String requestType;

  public RoomHandler(String requestType) {
    this.requestType = requestType;
  }

  @Override
  public void handle(HttpExchange exchange) throws IOException {
    System.out.println(LocalTime.now() + " Received communication: user handler/" + requestType);

    try {
      Boolean success = false; 

      switch(this.requestType) {
        case RequestType.CREATE:
          success = createRoom();
          break;
        case RequestType.DELETE:
          success = deleteRoom();
          break;
        case RequestType.UPDATE:
          success = updateRoom();
          break;
        default:
          System.out.println("Request type " + requestType + " not recognized");

        int responseCode = success ? HttpURLConnection.HTTP_OK : HttpURLConnection.HTTP_BAD_REQUEST;
        exchange.sendResponseHeaders(responseCode, 0);
        exchange.getResponseBody().close();
      }
    } catch (Exception e) {
      System.out.println(LocalTime.now() + " Exception: " + e.toString());

      exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, 0);
      exchange.getResponseBody().close();
    }
  }

  private boolean createRoom() {
    System.out.println(LocalTime.now() + " Creating room");
    return true;
  }

  private boolean deleteRoom() {
    System.out.println(LocalTime.now() + " Deleting room");
    return true;
}

private boolean updateRoom() {
    System.out.println(LocalTime.now() + " Update room");
    return true;
}
}
