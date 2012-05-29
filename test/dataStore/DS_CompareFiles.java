
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
import except.ExtenException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(value=Parameterized.class)
public class DS_CompareFiles {
    private ADS ds = null;
    private String file;
    private String type;

    public DS_CompareFiles(String type, String file) {
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
    public void testLoadMethodMANY() throws Exception 
    {
      PlantList lst = PlantMain.initListM();
      
      ds.setfName("IdealFiles\\"+file);
    
      assertEquals(lst.getList(), ds.load());
    }
    @Test
    public void testSaveMethodMANY() throws Exception 
    {
      PlantList lst = PlantMain.initListM();
      
      ds.setfName(file);
      ds.save(lst.getList());
     
      assertEquals(0, compareFiles(file));
    }
    
    private long getFileCRC32(File f) throws IOException {

        CheckedInputStream cis = new CheckedInputStream(new FileInputStream(f),  new CRC32());

        byte[] buf = new byte[128];
        while (cis.read(buf) >= 0) {
        }

        long res = cis.getChecksum().getValue();
        cis.close();
        return res;
    }

    private int compareFiles(String f1) throws IOException{

        int res = 0;

        File myFile = new File(f1);
        File patternFile = new File("IdealFiles"+ File.separator+f1);
        
        if (!myFile.exists()){
            res = 1;
        }
        else if (!patternFile.exists()){
            res = -1;
            }
            else if (myFile.length() != patternFile.length()){
                 res = 2;
                 }
                 else {
                 res = (int) (getFileCRC32(myFile) - getFileCRC32(patternFile));
    }

    return res;

    }
}
