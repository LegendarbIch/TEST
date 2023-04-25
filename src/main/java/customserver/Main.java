package customserver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        new Server().bootstrap();
    }
}
class Server {

    private AsynchronousServerSocketChannel server;

    private final static String HEADERS =
                      "HTTP/1.1 200 OK\n"
                    + "Server: Kirill\n"
                    + "Content-Type: text/html\n"
                    + "Content-Length: %s\n"
                    + "Connection: close\n\n";
    public void bootstrap() {
        try {
            server = AsynchronousServerSocketChannel.open();
            server.bind(new InetSocketAddress("127.0.0.1", 8081));
            Future<AsynchronousSocketChannel> future = server.accept();
            System.out.println("new client thread");
            AsynchronousSocketChannel clientChannel = future.get();

            while (clientChannel != null && clientChannel.isOpen() ) {
                ByteBuffer buffer = ByteBuffer.allocate(256);
                StringBuilder builder = new StringBuilder();
                boolean keepReading = true;

                while (keepReading) {
                    clientChannel.read(buffer).get();

                    int position = buffer.position();
                    keepReading = position == 256;

                    byte[] array = keepReading
                            ? buffer.array()
                            : Arrays.copyOfRange(buffer.array(), 0, position);

                    builder.append(new String(array));
                    buffer.clear();
                }
                String body = "<html><body><h1>Kuku, chuvak</h1></body></html>";
                String page = String.format(HEADERS, body.length()) + body;
                ByteBuffer resp = ByteBuffer.wrap(page.getBytes());
                clientChannel.write(resp);
                clientChannel.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
