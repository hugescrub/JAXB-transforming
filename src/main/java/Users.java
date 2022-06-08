import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "users", namespace = "http://namespace.com/Integration")
public class Users {

    private List<User> userList;

    // constructors
    public Users() {

    }

    public Users(List<User> userList) {
        this.userList = userList;
    }

    // ... getters & setters

    public List<User> getUsers() {
        return userList;
    }

    @XmlElement(name = "user", namespace = "http://namespace.com/Integration")
    public void setUsers(List<User> userList) {
        this.userList = userList;
    }

    public List<User> getByCountry(String country) {
        List<User> currentUsers = new ArrayList<>();
        for (User user : userList) {
            if (user.getCountry().equals(country)) {
                currentUsers.add(user);
            }
        }
        return currentUsers;
    }

    public List<User> getBySurname(String surname) {
        List<User> currentUsers = new ArrayList<>();
        for (User user : userList) {
            if (user.getFullname().contains(surname)) {
                currentUsers.add(user);
            }
        }
        return currentUsers;
    }

    public List<User> getByBeforeDate(Date date) {
        List<User> currentUsers = new ArrayList<>();
        for (User user : userList) {
            if (user.getRegistered().before(date)) {
                currentUsers.add(user);
            }
        }
        return currentUsers;
    }
}
