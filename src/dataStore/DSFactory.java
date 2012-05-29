package dataStore;

import except.ExtenException;
import java.util.HashMap;
import java.util.Map;
    
public class DSFactory {

    private static Map mp = null;
   
    public static ADS getInstance(String type)
    {   ADS ret=null;
        if(mp==null)
        {
            init();
        }
        return (ADS) mp.get(type);
    }

    private static void init() {
        mp = new HashMap<String, ADS>();  
            mp.put("csv", new DS_CSV());
            mp.put("xml", new DS_XML());
            mp.put("d1xml", new DS_domXML1());
            mp.put("d2xml", new DS_domXML2());
            mp.put("json", new DS_JSON());
            mp.put("yaml", new DS_YAML());
            mp.put("mock", new DS_Mock());
     
    }
}
