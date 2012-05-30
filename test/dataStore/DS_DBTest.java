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


public class DS_DBTest {
    private PList lst=PersonMain.initList1();

    
    @Test
    public void testMockMethod() throws IOException {
            
      DSFactory.getInstance("db").save(lst.getList());
     
     // assertEquals(lst.getList(), DSFactory.getInstance("mock").load());
    }
}
