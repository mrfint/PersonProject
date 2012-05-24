package model.dataStore;

import dataStore.ADS;
import dataStore.DSFactory;
import except.ExtenException;
import java.awt.Shape;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

public class DS_domXMLTest {
    private ADS ds = null;

//    @Test
//    public void testSaveMethod0() throws ExtenException, IOException {
//        List<Shape> lst = InitShapeList.initList0();
//        ds =  DSFactory.getInstance(new File("test\\Test0.xml"));
//        ds.save(lst);
//        assertEquals(lst, ds.load());
//    }
//    @Test
//    public void testSaveMethod1() throws ExtenException, IOException {
//        List<Shape> lst = InitShapeList.initList1();
//        ds =  DSFactory.getInstance(new File("test\\Test1.xml"));
//        ds.save(lst);
//        assertEquals(lst, ds.load());
//    }
//      @Test
//    public void testSaveMethodMany() throws ExtenException, IOException {
//        List<Shape> lst = InitShapeList.initListM();
//        ds =  DSFactory.getInstance(new File("test\\TestM.xml"));
//        ds.save(lst);
//        lst = ds.load();
//        ds =  DSFactory.getInstance(new File("test\\TestMnew.xml"));
//        ds.save(lst);
//    }
}
