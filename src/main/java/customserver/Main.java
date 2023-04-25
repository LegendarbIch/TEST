package customserver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        new Server().bootstrap();
    }
}
class Server {

    private AsynchronousServerSocketChannel server;
    public void bootstrap() {
        try {
            server = AsynchronousServerSocketChannel.open();
            server.bind(new InetSocketAddress("127.0.0.1", 8081));
            Future<AsynchronousSocketChannel> future = server.accept();
            System.out.println("new client thread");
            AsynchronousSocketChannel clientChannel = future.get();

            while (clientChannel != null && clientChannel.isOpen() ) {
                ByteBuffer buffer = ByteBuffer.allocate(256);

                clientChannel.read(buffer).get();

                clientChannel.write(buffer);

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
