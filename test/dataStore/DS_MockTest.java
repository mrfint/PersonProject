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
public class DS_MockTest {
    private PList lst=null;

    public DS_MockTest(PList lst) 
    {
        this.lst=lst;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> generateData()
    {
        Object[][] data = new Object[][] {
                        { PersonMain.initList0() }, 
                        { PersonMain.initList1() },
                        { PersonMain.initListM() },
       };
    return Arrays.asList(data);
    } 
    @Test
    public void testMockMethod() throws IOException {
            
      DSFactory.getInstance("mock").save(lst.getList());
     
      assertEquals(lst.getList(), DSFactory.getInstance("mock").load());
    }
}
