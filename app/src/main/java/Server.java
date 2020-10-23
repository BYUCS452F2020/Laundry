import com.sun.net.httpserver.HttpServer;

import handlers.MachineHandler;
import handlers.RoomHandler;
import handlers.TestHandler;
import handlers.UserHandler;
import models.RequestType;

import java.net.InetSocketAddress;
import java.time.LocalTime;
import java.util.Locale;

public class Server {

    private static final int MAX_WAITING_CONNECTIONS = 12;

    private HttpServer server;

    public static void main(String[] args) {
        String port_number = args.length > 0 ? args[0] : "8080";
        new Server().run(port_number);
    }

    private void run(String portNumber) {
        System.out.println(LocalTime.now() + " Running server on port: " + portNumber);

        try {
            server = HttpServer.create(new InetSocketAddress(Integer.parseInt(portNumber)), MAX_WAITING_CONNECTIONS);
        } catch (Exception e) {
            System.out.println(LocalTime.now() + " Error creating server");
            e.printStackTrace();
            return;
        }

        server.setExecutor(null);
        System.out.println(LocalTime.now() + " Server initialized");

        server.createContext("/test", new TestHandler());

        // USER
        server.createContext("/user/create", new UserHandler(RequestType.CREATE));
        server.createContext("/user/delete", new UserHandler(RequestType.DELETE));
        server.createContext("/user/update", new UserHandler(RequestType.UPDATE));

        // Room
        server.createContext("/room/delete", new RoomHandler(RequestType.DELETE));
        server.createContext("/room/create", new RoomHandler(RequestType.CREATE));
        server.createContext("/room/update", new RoomHandler(RequestType.UPDATE));

        // Machine
        server.createContext("/machine/delete", new MachineHandler(RequestType.DELETE));
        server.createContext("/machine/create", new MachineHandler(RequestType.CREATE));
        server.createContext("/machine/update", new MachineHandler(RequestType.UPDATE));
        server.createContext("/machine/status", new MachineHandler(RequestType.STATUS));

        //
        server.start();
        System.out.println(LocalTime.now() + " Server started.");
    }
}
