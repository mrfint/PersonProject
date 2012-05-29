
package dataStore;

import dataStore.DS_JSON;
import dataStore.ADS;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import plant.PlantList;
import plant.PlantList;
import dataStore.PlantMain;
import java.util.Arrays;
import java.util.Collection;
import org.hamcrest.Factory;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(value=Parameterized.class)
public class DS_01M_blackBox {
    private ADS ds = null;
    private String file;
    private String type;

    public DS_01M_blackBox(String type, String file) {
        this.type = type;
        this.file = file;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> generateData()
    {
        Object[][] data = new Object[][] {
                        { "csv", "test.csv" }, 
                        { "xml", "test.xml" },
                        { "json", "test.json" },
                        { "yaml", "test.yaml" },
                        { "d1xml", "testDom1.xml" },
                        { "d2xml", "testDom2.xml" },
       };
    return Arrays.asList(data);
    }
    @Before
    public void setup(){
       ds = DSFactory.getInstance(type);  
    }

    @Test
    public void testSaveLoadMethodZERO() throws Exception 
    {
      PlantList lst = PlantMain.initList0();
       
      ds.setfName(file);
      ds.save(lst.getList());
        
      assertEquals(lst.size(), ds.load().size());
      
    }
    

    @Test
    public void testSaveLoadMethodONE() throws Exception 
    {
      PlantList lst = PlantMain.initList1();

      ds.setfName(file);
      ds.save(lst.getList());
      assertEquals(lst.getList(), ds.load());
    }
    @Test
    public void testSaveLoadMethodMANY() throws Exception 
    {
      PlantList lst = PlantMain.initListM();
      
      ds.setfName(file);
      ds.save(lst.getList());
     
      assertEquals(lst.getList(), ds.load());
    }
}
