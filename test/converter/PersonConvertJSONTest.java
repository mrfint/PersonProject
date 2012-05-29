
package converter;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;


public class PersonConvertJSONTest {
    PersonConvertJSON t = new PersonConvertJSON();
    Person o1 = new Person();

    public PersonConvertJSONTest() {
        FlowerConvertXML t0 = new FlowerConvertXML();
        o1 = (Flower) t0.fromString("<Flower><id>0</id><name>Rose</name><location>Ukraine</location>"
                + "<color>red</color><structure>purpose</structure><qpetal>12</qpetal><spike>true</spike>"
                + "<temperature>30.0</temperature></Flower>");
    }
        
    @Test
    public void testFromString() {
        assertEquals(o1.toString(), t.fromString("{\"Flower\": {\"id\":\"0\",\"name\":\"Rose\",\"location\":"
               + "\"Ukraine\",\"color\":\"red\",\"structure\":\"purpose\",\"qpetal\":\"12\",\"spike\":"
               + "\"true\",\"temperature\":\"30.0\"}}").toString());
    }
    @Test
    public void testToString() {
        
        assertEquals("{\"Flower\": {\"id\":\"0\",\"name\":\"Rose\",\"location\":"
               + "\"Ukraine\",\"color\":\"red\",\"structure\":\"purpose\",\"qpetal\":\"12\",\"spike\":"
               + "\"true\",\"temperature\":\"30.0\"}}\r\n", t.toString(o1));
        
    }
}
