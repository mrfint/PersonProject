
package dataStore;

import dataStore.DS_JSON;
import dataStore.ADS;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import dataStore.PersonMain;
import except.ExtenException;
import java.util.Arrays;
import java.util.Collection;
import org.hamcrest.Factory;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import person.PList;

@RunWith(value=Parameterized.class)
public class DS_01M_blackBox {
    private ADS ds = null;
    private String file;

    public DS_01M_blackBox(String file) {
        this.file = file;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> generateData()
    {
        Object[][] data = new Object[][] {
                        { "test.csv" }, 
                        { "db.db" },
                        { "mock.xml" },
                        { "test.json" },
                        { "test.yaml" },
                        { "test.xml" },
                        { "test.net" }
       };
    return Arrays.asList(data);
    }
    @Before
    public void setup() throws ExtenException{
       ds = DSFactory.getInstance(file);  
    }
    
    @Test
    public void testSaveLoadMethodZERO() throws Exception 
    {
      PList lst = PersonMain.initList0();
       
      ds.save(lst.getList());
        
      assertEquals(lst.getList(), ds.load());
      
    }
    

    @Test
    public void testSaveLoadMethodONE() throws Exception 
    {
      PList lst = PersonMain.initList1();

      ds.save(lst.getList());
      assertEquals(lst.getList(), ds.load());
    }
    @Test
    public void testSaveLoadMethodMANY() throws Exception 
    {
      PList lst = PersonMain.initListM();
      
      ds.save(lst.getList());
     
      assertEquals(lst.getList(), ds.load());
    }
}
