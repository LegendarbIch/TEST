package valutecourse;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "ValCurs")
@XmlAccessorType(XmlAccessType.FIELD)
public class ValCurs {

    @XmlAttribute(name = "Data")
    private String data;

    @XmlAttribute(name = "name")
    private String name;

    @XmlElement(name = "Valute")
    private List<Valute> valute;

    @Override
    public String toString() {
        return "ValCurs{" +
                "data='" + data + '\'' +
                ", name='" + name + '\'' +
                ", valute=" + valute +
                '}';
    }

    public String getData() {
        return data;
    }

    public String getName() {
        return name;
    }

    public List<Valute> getValute() {
        return valute;
    }
}
