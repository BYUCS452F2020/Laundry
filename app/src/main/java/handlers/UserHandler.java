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

public class UserHandler implements HttpHandler {
    private String type;

    public UserHandler(String type) {
        this.type = type;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        System.out.println(LocalTime.now() + " Received communication: user handler/" + type);

        try {
            switch (this.type) {
                case RequestType.CREATE:
                    CreateUser();
                    break;
                case RequestType.DELETE:
                    DeleteUser();
                    break;
                case RequestType.UPDATE:
                    UpdateUser();
                    break;
                default:
                    throw new IOException("No type");
            }

            // Return 200 response
            exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
            exchange.getResponseBody().close();


            exchange.sendResponseHeaders(HttpURLConnection.HTTP_BAD_REQUEST, 0);
            exchange.getResponseBody().close();
        } catch (IOException e){
            System.out.println(LocalTime.now() + " Exception: " + e.toString());
        }
    }

    private boolean CreateUser() {
        System.out.println(LocalTime.now() + " Creating user");
        return true;
    }

    private boolean DeleteUser() {
        System.out.println(LocalTime.now() + " Deleting user");
        return true;
    }

    private boolean UpdateUser() {
        System.out.println(LocalTime.now() + " Update user");
        return true;
    }
}
