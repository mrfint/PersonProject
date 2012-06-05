package dataStore;

import java.io.IOException;
import java.util.List;
import person.Person;

public abstract class ADS {
    public static String fName="storage.xml";
    
    public abstract void save(List<Person> ls) throws IOException;
    public abstract List<Person> load() throws IOException;
}
