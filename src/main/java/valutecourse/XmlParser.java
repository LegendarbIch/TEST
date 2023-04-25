package valutecourse;




import valutecourse.entity.ValCurs;
import valutecourse.entity.Valute;
import valutecourse.repository.PostgresValCursDao;
import valutecourse.repository.PostgresValuteDao;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.net.*;

import java.sql.SQLException;
import java.util.stream.Collectors;

public class XmlParser<T> {

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
