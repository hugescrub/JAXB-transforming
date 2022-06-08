import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@XmlRootElement(name = "user", namespace = "http://namespace.com/Integration")
@XmlType(propOrder = { "id", "fullname", "email", "country", "town", "registered", "address" })
public class User {

    private Long id;
    private String fullname;
    private String email;
    private String country;
    private String town;
    private Date registered;
    private String address;

    public Long getId() {
        return id;
    }

    @XmlAttribute(name = "id", required = true)
    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    @XmlElement(name = "fullname", namespace = "http://namespace.com/Integration")
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    @XmlElement(name = "email", namespace = "http://namespace.com/Integration")
    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    @XmlElement(name = "country", namespace = "http://namespace.com/Integration")
    public void setCountry(String country) {
        this.country = country;
    }

    public String getTown() {
        return town;
    }

    @XmlElement(name = "town", namespace = "http://namespace.com/Integration")
    public void setTown(String town) {
        this.town = town;
    }

    public Date getRegistered() {
        return registered;
    }

    @XmlElement(name = "registered", namespace = "http://namespace.com/Integration")
    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public String getAddress() {
        return address;
    }

    @XmlElement(name = "address", namespace = "http://namespace.com/Integration")
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("id:").append("\"").append(id).append("\"").append(",");
        sb.append("fullname:").append("\"").append(fullname).append("\"").append(",");
        sb.append("email:").append("\"").append(email).append("\"").append(",");
        sb.append("country:").append("\"").append(country).append("\"").append(",");
        sb.append("town:").append("\"").append(town).append("\"").append(",");
        sb.append("registered:").append("\"").append(registered).append("\"").append(",");
        sb.append("address:").append("\"").append(address).append("\"");
        sb.append("}");
        return sb.toString();
    }
}
