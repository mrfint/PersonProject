
package converter;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import plant.Flower;
import plant.Tree;

public class PersonConvertYAMLTest {
    FlowerConvertYAML t = new FlowerConvertYAML();
    Flower o1 = new Flower();

    public PersonConvertYAMLTest() {
        FlowerConvertXML t0 = new FlowerConvertXML();
        o1 = (Flower) t0.fromString("<Flower><id>0</id><name>Rose</name><location>Ukraine</location>"
                + "<color>red</color><structure>purpose</structure><qpetal>12</qpetal><spike>true</spike>"
                + "<temperature>30.0</temperature></Flower>");
    }
        
    @Test
    public void testToString() {
        
        System.out.println(t.toString(o1));
        
    }
}
