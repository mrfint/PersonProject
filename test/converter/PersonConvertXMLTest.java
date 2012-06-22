
package converter;

import model.converter.PersonConvertXML;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import model.person.Person;

public class PersonConvertXMLTest {
    PersonConvertXML t = new PersonConvertXML();
    Person o1 = null;

    public PersonConvertXMLTest() {
        o1 = new Person(0,"Gary","Portman",30,"user.jpg","75964");
    }
        
    @Test
    public void testFromString() {
         assertEquals(t.fromString("{\"Person\": {\"id\":\"0\",\"fn\":\"Gary\",\"ln\":\"Portman\",\"age\":\"30\"}\r\n"), o1);
    }
    @Test
    public void testToString() {
        
        assertEquals(t.toString(o1), "{\"Person\": {\"id\":\"0\",\"fn\":\"Gary\",\"ln\":\"Portman\",\"age\":\"30\"}\r\n");   
    }
}
