package httpTraining;

import java.io.IOException;
import java.net.InetSocketAddress;

public class HttpServerCreate {

    public void getServer() throws IOException {
        com.sun.net.httpserver.HttpServer httpServer = com.sun.net.httpserver.HttpServer.create();
        httpServer.bind(new InetSocketAddress(7071), 0);
        httpServer.createContext("/bebra", new HelloHandler());
        httpServer.start();
    }
}
