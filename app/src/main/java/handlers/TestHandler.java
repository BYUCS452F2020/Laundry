package handlers;

import com.sun.net.httpserver.*;

import java.io.IOException;
import java.net.*;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public class TestHandler implements HttpHandler {

    public TestHandler() {}

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        System.out.println(LocalTime.now() + " Received communication: test handler");
        try {
            if (exchange.getRequestMethod().toLowerCase().equals("get")) {
                throw new Exception("Wrong method (should be post)");
            }

            // Read url query
            String query = exchange.getRequestURI().getQuery();
            System.out.println("Query: " + query + "\n");

            // Read headers
            Headers headers = exchange.getRequestHeaders();
            for (Map.Entry<String, List<String>> entry : headers.entrySet())  {
                StringBuilder sb = new StringBuilder();
                sb.append(entry.getKey() + ": ");
                for(String str : entry.getValue()) {
                    sb.append(str + ", ");
                }
                //System.out.println(sb.toString());
            }

            // Return 200 response
            exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
            exchange.getResponseBody().close();
        } catch (Exception e) {
            System.out.println(LocalTime.now() + " Exception: " + e.toString());

            exchange.sendResponseHeaders(HttpURLConnection.HTTP_BAD_REQUEST, 0);
            exchange.getResponseBody().close();
        }
    }
}
