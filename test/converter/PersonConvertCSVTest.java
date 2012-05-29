
package converter;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import person.Person;

public class PersonConvertCSVTest {
    PersonConvertCSV t = new PersonConvertCSV();
    Person o1 = new Person();

    public PersonConvertCSVTest() 
    {
        o1 = new Person(0,"Gary","Portman",30);
    }
        
    @Test
    public void testToString() 
    {
        assertEquals(t.toString(o1), "Person;0;Gary;Portman;30;\r\n");
    }
    
    @Test
    public void testFromString(){
        assertEquals(t.fromString("Person;0;Gary;Portman;30;\r\n"), o1);
    }
}
