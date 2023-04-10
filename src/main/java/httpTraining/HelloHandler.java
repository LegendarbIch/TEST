package httpTraining;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class HelloHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        System.out.println("чето происходит");
        String response = "<ValCurs Date=\"02.03.2002\" name=\"Foreign Currency Market\">\n" +
                        "    <link type=\"text/css\" rel=\"stylesheet\" id=\"dark-mode-custom-link\"/>\n" +
                        "    <link type=\"text/css\" rel=\"stylesheet\" id=\"dark-mode-general-link\"/>\n" +
                        "    <style lang=\"en\" type=\"text/css\" id=\"dark-mode-custom-style\"/>\n" +
                        "    <style lang=\"en\" type=\"text/css\" id=\"dark-mode-native-style\"/>\n" +
                        "    <Valute ID=\"R01010\">\n" +
                        "        <NumCode>036</NumCode>\n" +
                        "        <CharCode>AUD</CharCode>\n" +
                        "        <Nominal>1</Nominal>\n" +
                        "        <Name>Австралийский доллар</Name>\n" +
                        "        <Value>16,0102</Value>\n" +
                        "    </Valute>\n" +
                        "</ValCurs>";
        exchange.sendResponseHeaders(200,0);

//        //тело запроса
//        InputStream inputStream = exchange.getRequestBody();
//        String body = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
//        System.out.println("Тело запроса " + body + "\n");
//
//        //http метод
//        String requestMethod = exchange.getRequestMethod();
//        System.out.println("метод " + requestMethod + "\n");
//
//        //заголовки
//        Headers requestHeaders = exchange.getRequestHeaders();
//        System.out.println("заголовок " + requestHeaders.entrySet() + "\n");
//
//        //конкретный заголовок
//        List<String> contentTypeValues = requestHeaders.get("X-jopa");
//        if (contentTypeValues != null && contentTypeValues.contains("shit")) {
//            System.out.println("Это рил трэп щит!");
//        }
//
//        //URI
//        URI requesURI = exchange.getRequestURI();
//        String path = requesURI.getPath();
//        System.out.println("\n" + path);

        try (OutputStream os = exchange.getResponseBody()) {
            os.write(response.getBytes());
        }
    }
}
