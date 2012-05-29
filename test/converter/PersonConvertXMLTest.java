
package converter;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import plant.Flower;
import plant.Tree;

public class PersonConvertXMLTest {
    FlowerConvertXML t = new FlowerConvertXML();
    Flower o1 = new Flower();

    public PersonConvertXMLTest() {
        o1 = (Flower) t.fromString("<Flower><id>0</id><name>Rose</name><location>Ukraine</location>"
                + "<color>red</color><structure>purpose</structure><qpetal>12</qpetal><spike>true</spike>"
                + "<temperature>30.0</temperature></Flower>");
    }
        
    @Test
    public void testFromString() {
        assertEquals(o1.toString(), "Flower: id: 0, name :Rose, location: Ukraine, color: red, structure: "
                + "purpose, qoual of petal: 12, spike:true, temperature(C):30.0;\r\n");
    }
    @Test
    public void testToString() {
        assertEquals("<Flower><id>0</id><name>Rose</name><location>Ukraine</location>"
                + "<color>red</color><structure>purpose</structure><qpetal>12</qpetal><spike>true</spike>"
                + "<temperature>30.0</temperature></Flower>\r\n", t.toString(o1));
    }
}
