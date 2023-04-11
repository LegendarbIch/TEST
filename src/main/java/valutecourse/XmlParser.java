package valutecourse;




import valutecourse.entity.ValCurs;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.net.*;

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
