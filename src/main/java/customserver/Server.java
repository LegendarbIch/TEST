package customserver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

class Server {

    private AsynchronousServerSocketChannel server;

    private final HttpHandlerr handlerr;

    public Server(HttpHandlerr handlerr) {
        this.handlerr = handlerr;
    }

    public void bootstrap() {
        try {
            server = AsynchronousServerSocketChannel.open();
            server.bind(new InetSocketAddress("127.0.0.1", 8081));

            while (true) {
                Future<AsynchronousSocketChannel> future = server.accept();
                bodyHandler(future);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private void bodyHandler(Future<AsynchronousSocketChannel> future) throws InterruptedException, ExecutionException, IOException {
        System.out.println("new client connection");
        AsynchronousSocketChannel clientChannel = future.get();
        while (clientChannel != null && clientChannel.isOpen()) {
            ByteBuffer buffer = ByteBuffer.allocate(256);
            StringBuilder builder = new StringBuilder();
            boolean keepReading = true;

            while (keepReading) {
                int readResult = clientChannel.read(buffer).get();

                keepReading = readResult == 256;
                buffer.flip();
                CharBuffer decode = StandardCharsets.UTF_8.decode(buffer);
                builder.append(decode);

                buffer.clear();
            }
            HttpRequest httpRequest = new HttpRequest(builder.toString());
            HttpResponse httpResponse = new HttpResponse();

            if (handlerr != null ) {
                try {
                    String body = this.handlerr.handle(httpRequest, httpResponse);

                    if (body != null && !body.isBlank()) {
                        if (httpResponse.getHeaders().get("Content-Type") == null) {
                            httpResponse.addHeader("Content-Type", "text/html; charset=utf-228");
                        }
                        httpResponse.setBody(body);
                    }
                } catch (Exception e) {
                    e.printStackTrace();

                    httpResponse.setStatusCode(500);
                    httpResponse.setStatus("Internal server error");
                    httpResponse.addHeader("Content-Type", "text/html; charset=utf-8");
                    httpResponse.setBody("<html><body><h1>Error</h1></body></html>");
                }


            } else {
                httpResponse.setStatusCode(404);
                httpResponse.setStatus("Not found");
                httpResponse.addHeader("Content-Type", "text/html; charset=utf-8");
                httpResponse.setBody("<html><body><h1>Resource not found</h1></body></html>");
            }

            ByteBuffer resp = ByteBuffer.wrap(httpResponse.getBytes());

            clientChannel.write(resp);


            clientChannel.close();
        }
    }
}
