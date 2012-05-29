package dataStore;

import except.ExtenException;
import java.io.IOException;
import java.util.List;
import person.Person;

public abstract class ADS {
    private String fName="plant.xml";

    public String getfName() {
        return fName;
    }
    
    public void setfName(String fName) throws ExtenException {
        String fileExt = fName.substring(fName.lastIndexOf('.'));
        
        if((fileExt.toLowerCase().equals(".csv"))||(fileExt.toLowerCase().equals(".xml"))
         ||(fileExt.toLowerCase().equals(".yaml"))||(fileExt.toLowerCase().equals(".json")))
          { this.fName=fName;  }
        else throw new ExtenException();
        
    }

    public abstract void save(List<Person> ls) throws IOException;
    public abstract List<Person> load() throws IOException;
}
