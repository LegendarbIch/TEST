package httpTraining;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class URIResource {

    public static void main(String[] args) throws IOException, InterruptedException {

        URI uri = URI.create("https://yandex.ru/search/?text=пожиратель+душ+аниме&lr=193&clid=2270455&win=588");

        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder();

        HttpRequest request = requestBuilder
                .GET()
                .uri(uri)
                .build();

        HttpClient client = HttpClient.newHttpClient();

        try {
            HttpResponse.BodyHandler<String> handler = HttpResponse.BodyHandlers.ofString();
            HttpResponse<String> response = client.send(request, handler);
            int status = response.statusCode();


            if(status >= 200 && status <= 299) {
                System.out.println("Сервер успешно обработал запрос. Код состояния " + status);
                System.out.println(response.body());
                JsonElement jsonElement = JsonParser.parseString(response.body());
                if(!jsonElement.isJsonObject()) {
                    System.out.println("Ответ от сервера не соответствует");
                    return;
                }
                System.out.println("Тело ответа:" + jsonElement);
            }

            if(status >= 400 && status <=499) {
                System.out.println("Сервер сообщил о проблеме с запросом. Код состояния " + status);
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("Во время выполнения запроса возникла ошибка. Проверьте, URL-адрес");
        } catch (IllegalArgumentException e) {
            System.out.println("Введенный адрес не соответствует формату URL.");
        }
    }
}
