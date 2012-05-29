
package converter;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import person.Person;

public class PersonConvertYAMLTest {
    PersonConvertYAML t = new PersonConvertYAML();
    Person o1 = null;

    public PersonConvertYAMLTest() {
        o1 = new Person(0,"Gary","Portman",30);
    }
        
    @Test
    public void testFromString() {
         assertEquals(t.fromString("***Person*******************\r\n\t id : 0\r\n\t fn : Gary\r\n\t ln : Portman\r\n\t age : 30\t\r\n****************************\r\n"), o1);
    }
    @Test
    public void testToString() {
        
        assertEquals(t.toString(o1), "***Person*******************\r\n\t id : 0\r\n\t fn : Gary\r\n\t ln : Portman\r\n\t age : 30\t\r\n****************************\r\n");   
    }
}
