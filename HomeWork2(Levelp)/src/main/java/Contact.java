import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Created by labib's pc on 3/1/2017.
 */
public class Contact implements Serializable {
    private String firstName;
    private String secondName;
    private List<String> phones;

    public Contact(String firstName, String secondName, String... phones) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.phones = Arrays.asList(phones);

    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public List<String> getPhones() {
        return phones;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", phones=" + phones +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (firstName != null ? !firstName.equals(contact.firstName) : contact.firstName != null)
            return false;
        if (secondName != null ? !secondName.equals(contact.secondName) : contact.secondName != null)
            return false;
        if (phones != null ? !phones.equals(contact.phones) : contact.phones != null) return false;

        return true;
    }

}
