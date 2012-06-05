package dataStore;

import except.ExtenException;
import java.util.HashMap;
import java.util.Map;
    
public class DSFactory {

    private static Map mp = null;

    public static ADS getInstance(String fName) throws ExtenException
    {   

        if(mp==null)
        {
            init();
        }
        
        String fileExt = fName.substring(fName.lastIndexOf('.')+1).toLowerCase();
        
        
        if(    (fileExt.equals("csv"))  || (fileExt.equals("xml"))  || (fileExt.equals("yaml"))
            || (fileExt.equals("json")) || (fileExt.equals("mock")) || (fileExt.equals("net"))
            || (fileExt.equals("db")) 
           )       
        { 
              ADS.fName=fName;  
        }
        else
        { 
            throw new ExtenException();
        }
        return (ADS) mp.get(fileExt);
    }

    private static void init() {
        mp = new HashMap<String, ADS>();  
            mp.put("csv", new DS_CSV());
            mp.put("xml", new DS_XML());
            mp.put("json", new DS_JSON());
            mp.put("yaml", new DS_YAML());
            mp.put("mock", new DS_Mock());
            mp.put("net", new DS_Net_Client());
            mp.put("db", new DS_DB());
     
    }
}
