import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class HHTTPCOCK {

    public void getServer() throws IOException {
        HttpServer httpServer = HttpServer.create();
        httpServer.bind(new InetSocketAddress(8080), 0);
        httpServer.createContext("/bebra", new HelloHandler());
        httpServer.start();
        System.out.println(httpServer.getAddress());
    }
}
