import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Root", namespace = "http://namespace.com/Integration")
public class Root {
    Users users;

    public Users getUsers() {
        return users;
    }

    @XmlElement(name = "users", namespace = "http://namespace.com/Integration")
    public void setUsers(Users users) {
        this.users = users;
    }
}
