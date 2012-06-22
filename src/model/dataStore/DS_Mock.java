
package model.dataStore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.person.Person;

public class DS_Mock extends ADS{
    private ArrayList<Person> lst = null;

    @Override
    public void save(List<Person> ls) throws IOException {
       this.lst = (ArrayList<Person>) ((ArrayList<Person>) ls).clone();
    }

    @Override
    public List<Person> load() throws IOException {
        return lst;
    }
}
