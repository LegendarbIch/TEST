package valutecourse;


import com.sun.net.httpserver.HttpServer;
import com.sun.xml.bind.v2.runtime.output.Encoded;
import httpTraining.HelloHandler;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class XmlParser<T> {
    public static void main(String[] args) throws IOException, JAXBException {
        XmlParser<ValCurs> parser = new XmlParser<>();
//        Scanner scanner = new Scanner(System.in);
//        String date = scanner.nextLine();
//        String url = "https://cbr.ru/scripts/XML_daily.asp?date_req=" +date;
//        ValCurs valCurs = parser.xmlParser(ValCurs.class, url);
//        System.out.print(valCurs.getValute().get(0).getName() + " = " + valCurs.getValute().get(0).getValue());
//        com.sun.net.httpserver.HttpServer httpServer = com.sun.net.httpserver.HttpServer.create();
//        httpServer.bind(new InetSocketAddress(9090), 0);
//        httpServer.createContext("/bebra", new HelloHandler());
//        httpServer.start();

        System.out.print(parser.xmlParser(ValCurs.class, "https://www.cbr.ru/scripts/XML_daily.asp"));
    }

    public Optional<String> getXMLResponse(String url) throws MalformedURLException {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            HttpURLConnection httpConn = (HttpURLConnection) new URL(url).openConnection();

            BufferedReader rd = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));

            return Optional.of(rd.lines().collect(Collectors.joining()));

        }catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


    public T xmlParser(Class<T> obj, String url) throws IOException, JAXBException {
        HttpURLConnection httpConn = (HttpURLConnection) new URL(url).openConnection();

        InputStreamReader isr = new InputStreamReader(httpConn.getInputStream(), "windows-1251");
        BufferedReader br = new BufferedReader(isr);
        String body = br.lines().collect(Collectors.joining());

        StringReader reader = new StringReader(body);

        JAXBContext context = JAXBContext.newInstance(obj);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (T) unmarshaller.unmarshal(reader);
    }


}
