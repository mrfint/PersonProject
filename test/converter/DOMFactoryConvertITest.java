/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class DOMFactoryConvertITest {
    
    @Test
    public void testSomeMethod() {
        
        assertEquals("TreeConvertDomXML", FactoryConvertDOMi.getInstance("Tree").getClass().getSimpleName());
        assertEquals("FlowerConvertDomXML", FactoryConvertDOMi.getInstance("Flower").getClass().getSimpleName());
    }
}
