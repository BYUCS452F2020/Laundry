package handlers;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import models.RequestType;

import java.io.IOException;
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
                default:
                    System.out.println("Request type " + type + " not recognized");

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

    private boolean createUser() {
        System.out.println(LocalTime.now() + " Creating user");
        return true;
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
        // Get parameters from query
        String query = exchange.getRequestURI().getQuery();

        for (String param : query.split("&")) {
            String[] entry = param.split("=");
            if (entry.length > 1) {
                exchangeParameters.put(entry[0], entry[1]);
            }else{
                exchangeParameters.put(entry[0], "");
            }
        }

        // Get headers
        Headers headers = exchange.getRequestHeaders();
        for (Map.Entry<String, List<String>> entry : headers.entrySet())  {
            StringBuilder sb = new StringBuilder();
            for(String str : entry.getValue()) {
                sb.append(str);
            }
            exchangeParameters.put(entry.getKey(), sb.toString());
        }
    }
}
