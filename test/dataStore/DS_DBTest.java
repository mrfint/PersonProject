package dataStore;

import model.dataStore.DSFactory;
import model.except.ExtenException;
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
import model.person.PList;


public class DS_DBTest {
    
    private PList lst=PersonMain.initList0();

    @Test
    public void testMockMethod() throws IOException, ExtenException {
            
      DSFactory.getInstance("1.db").save(lst.getList());
     
      assertEquals(lst.getList(), DSFactory.getInstance("1.db").load());
    }
}
