package valutecourse.entity;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "ValCurs")
@XmlAccessorType(XmlAccessType.FIELD)
public class ValCurs {

    @XmlAttribute(name = "Date")
    private String date;

    @XmlAttribute(name = "name")
    private String name;

    @Expose
    @XmlElement(name = "Valute")
    private List<Valute> valute;

    @Override
    public String toString() {
        return "ValCurs{" +
                "data='" + date + '\'' +
                ", name='" + name + '\'' +
                ", valute=" + valute +
                '}';
    }

    public String getDate() {
        return date.subSequence(6,10) + "-" + date.subSequence(3, 5) + "-" + date.subSequence(0, 2);
    }

    public String getName() {
        return name;
    }

    public List<Valute> getValute() {
        return valute;
    }
}
