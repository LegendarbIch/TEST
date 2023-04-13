package valutecourse.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Valute {
    @XmlAttribute(name = "ID")
    private String id;
    @XmlElement(name ="NumCode")
    private int numCode;
    @XmlElement(name = "CharCode")
    private String charCode;
    @XmlElement(name ="Nominal")
    private int nominal;
    @XmlElement(name = "Name")
    private String name;
    @XmlElement(name = "Value")
    private String value;

    @Override
    public String toString() {
        return "\n Valute{" +
                "id='" + id + '\n' +
                ", numCode=" + numCode + "\n" +
                ", charCode='" + charCode + '\n' +
                ", nominal=" + nominal + "\n" +
                ", name=" + name + '\n' +
                ", value=" + value +
                '}';
    }

    public String getId() {
        return id;
    }

    public int getNumCode() {
        return numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public int getNominal() {
        return nominal;
    }

    public String getName() {
        return name;
    }

    public Double getValue() {
        return Double.valueOf(value.replace(",", "."));
    }
}
