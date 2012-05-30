
package converter;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import person.Person;


public class PersonConvertJSONTest {
    PersonConvertJSON t = new PersonConvertJSON();
    Person o1 = null;

    public PersonConvertJSONTest() {
        o1 = new Person(0,"Gary","Portman",30);
    }
        
    @Test
    public void testFromString() {
         assertEquals(t.fromString("{\"Person\": {\"id\":\"0\",\"fn\":\"Gary\",\"ln\":\"Portman\",\"age\":\"30\"}"), o1);
    }
    @Test
    public void testToString() {
        assertEquals(t.toString(o1), "{\"Person\": {\"id\":\"0\",\"fn\":\"Gary\",\"ln\":\"Portman\",\"age\":\"30\"}");   
    }
}
