package valutecourse;

import valutecourse.entity.ValCurs;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class ValCursDataCollector {
    private XmlParser<ValCurs> parser;
    public ValCurs getDailyCourse(){
        try {
            parser = new XmlParser<>();
            return parser.xmlParser(ValCurs.class, "https://www.cbr.ru/scripts/XML_daily.asp");
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ValCurs getCourseByDate(String date) {
        try {
            parser = new XmlParser<>();
            return parser.xmlParser(ValCurs.class, "https://www.cbr.ru/scripts/XML_daily.asp?date_req="+date);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
