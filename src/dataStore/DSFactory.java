package dataStore;

import except.ExtenException;
import java.io.File;
import java.util.HashMap;


public abstract class DSFactory {
	
	private static ADS ds = null;
	
	public static ADS getInstance(File file) throws ExtenException
        {
		if(ds == null)  
                { 
                    ds = new DS_domXML();		
                }
		String fExt=file.getName().substring(file.getName().lastIndexOf('.')+1).toLowerCase();
	
		ADS res = ds.checkType(fExt);
		if(res!=null)
                {
                    res.setFile(file);
                }
		return res;
	}

}
