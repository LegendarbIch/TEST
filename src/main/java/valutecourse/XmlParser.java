package valutecourse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.stream.Collectors;

public class XmlParser {
    public static void main(String[] args) throws MalformedURLException {
        XmlParser xmlParser = new XmlParser();
        System.out.println(xmlParser.getXMLResponse("www.cbr.ru/scripts/XML_daily.asp"));
    }

    public Optional<String> getXMLResponse(String url) throws MalformedURLException {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            HttpURLConnection httpConn = (HttpURLConnection) new URL(url).openConnection();

            BufferedReader rd = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), StandardCharsets.UTF_8));

            return Optional.of(rd.lines().collect(Collectors.joining(System.lineSeparator())));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
