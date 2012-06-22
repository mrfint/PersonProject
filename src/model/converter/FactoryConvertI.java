
package model.converter;

public class FactoryConvertI {
    private static IConvert[][] arr = new IConvert[][]{{new PersonConvertCSV()},
                                                       {new PersonConvertXML()},
                                                       {new PersonConvertJSON()},
                                                       {new PersonConvertYAML()},
                                                      };
    
    
    public static IConvert getInstance(String style, String type)
    {   
        int i=0, j=0;
        IConvert res=null;
        
        if(style.equals("csv" )) {i=0;  }
        if(style.equals("xml" )) {i=1;  }
        if(style.equals("json")) {i=2;  }
        if(style.equals("yaml")) {i=3;  }

        
        res = arr[i][j];
        
        return res;
    }
    
}
