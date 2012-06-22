
package converter;

import model.converter.PersonConvertJSON;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import model.person.Person;


public class PersonConvertJSONTest {
    PersonConvertJSON t = new PersonConvertJSON();
    Person o1 = null;

    public PersonConvertJSONTest() {
        o1 = new Person(0,"Gary","Portman",30,"user.jpg","75964");
    }
        
    @Test
    public void testFromString() {
         assertEquals(t.fromString("{\"Person\": {\"id\":\"0\",\"fn\":\"Gary\",\"ln\":\"Portman\",\"age\":\"30\",\"image\":\"user.jpg\",\"phones\":\"75964\" }"), o1);
    }
    @Test
    public void testToString() {
        assertEquals(t.toString(o1), "{\"Person\": {\"id\":\"0\",\"fn\":\"Gary\",\"ln\":\"Portman\",\"age\":\"30\",\"image\":\"user.jpg\",\"phones\":\"75964\"}");   
    }
}
