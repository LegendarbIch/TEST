package valutecourse.entity;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Valute {

    @Expose
    @XmlAttribute(name = "ID")
    private String id;
    @Expose
    @XmlElement(name ="NumCode")
    private int numCode;

    @Expose
    @XmlElement(name = "CharCode")
    private String charCode;

    @Expose
    @XmlElement(name ="Nominal")
    private int nominal;
    @Expose
    @XmlElement(name = "Name")
    private String name;
    @Expose
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
