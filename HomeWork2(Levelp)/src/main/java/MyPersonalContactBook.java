import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Artem Karnov @date 03.03.17.
 *         artem.karnov@t-systems.com
 */

public class MyPersonalContactBook implements ContactBook {

    private String fileName;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    private void writeObject(Object object, String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(object);
    }

    private Object readObject(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object obj = ois.readObject();
        return obj;
    }


    @Override
    public Void save(String fileName, List<Contact> list) {
        try {
            writeObject(list, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Contact> load(String fileName) {
        List<Contact> result = null;
        try {
            result = (List<Contact>) readObject(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Contact> search(String start)  {
        List<Contact> list = null;
        try {
            list = (List<Contact>) readObject(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        List<Contact> result = new ArrayList<>();
        for (Contact currentContact : list) {
            if (currentContact.getFirstName().contains(start))
                result.add(currentContact);
            else {
                for (String currentNumber : currentContact.getPhones())
                    if (currentNumber.contains(start)) {
                        result.add(currentContact);
                    }
            }
        }

        return result;
    }
}
