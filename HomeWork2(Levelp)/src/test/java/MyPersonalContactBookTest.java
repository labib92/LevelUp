import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Artem Karnov @date 03.03.17.
 *         artem.karnov@t-systems.com
 */

public class MyPersonalContactBookTest {
    List<Contact> contacts;
    Contact contactOne;
    Contact contactTwo;
    private MyPersonalContactBook myPersonalContactBook;

    @Before
    public void setUp() {
        myPersonalContactBook = new MyPersonalContactBook();
        contacts = new ArrayList<>();
        contactOne = new Contact("Labib", "Saleh", "2131");
        contactTwo = new Contact("Artyom", "karnov", "214189", "264");
        contacts.add(contactOne);
        contacts.add(contactTwo);

    }

    @Test
    public void testSave() throws Exception {
        myPersonalContactBook.save("Test.txt", contacts);
        List<Contact> result = myPersonalContactBook.load("Test.txt");
        Assert.assertEquals(contacts, result);

    }

    @Test
    public void testSearchOne() throws Exception {
        myPersonalContactBook.save("Test.txt", contacts);
        myPersonalContactBook.setFileName("Test.txt");
        List<Contact> result1 = myPersonalContactBook.search("1w");
        Assert.assertEquals(result1, new ArrayList<Contact>());

    }

    @Test
    public void testSearchThree () throws Exception {
        myPersonalContactBook.save("Test.txt", contacts);
        myPersonalContactBook.setFileName("Test.txt");
        List<Contact> result1 = myPersonalContactBook.search("2141");
        Assert.assertEquals(result1, Arrays.asList(contactTwo));
    }
    @Test
    public void testSearchFour () throws Exception {
        myPersonalContactBook.save("Test.txt", contacts);
        myPersonalContactBook.setFileName("Test.txt");
        List<Contact> result1 = myPersonalContactBook.search("21");
        Assert.assertEquals(result1, Arrays.asList(contactOne ,contactTwo ));
    }


}