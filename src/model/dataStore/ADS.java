package model.dataStore;

import java.io.IOException;
import java.util.List;
import model.person.Person;

public abstract class ADS {
    public static String fName="storage.xml";
    
    public abstract List<Person> load() throws IOException;
    
    public abstract void create(Person p) throws IOException;
    public abstract void update(List<Person> ls) throws IOException;
    public abstract void delete(List<Person> ls) throws IOException;
}
