package dataStore;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import person.PList;


@RunWith(value=Parameterized.class)
public class DS_NetTest {
    private PList lst=null;

    public DS_NetTest(PList lst) 
    {
        this.lst=lst;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> generateData()
    {
        Object[][] data = new Object[][] {
          //              { PersonMain.initList0() }, 
                        { PersonMain.initList1() },
          //              { PersonMain.initListM() },
       };
    return Arrays.asList(data);
    } 
    @Test
    public void testSaveLoadNet() throws IOException {
        
     //DSFactory.getInstance("net").save(lst.getList());
     
      assertEquals(lst.getList(), DSFactory.getInstance("net").load());
    }
}
