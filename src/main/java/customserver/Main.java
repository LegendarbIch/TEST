package customserver;

public class Main {
    public static void main(String[] args) {
        new Server(new HttpHandlerr() {
            @Override
            public String handle(HttpRequest request, HttpResponse response) {

                    return "<html><body><h1>Kuku, chuvak</h1>It handler</body></html>";
            }
        }).bootstrap();
    }
}
