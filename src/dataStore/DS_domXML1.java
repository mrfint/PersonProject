package dataStore;

import converter.FactoryConvertDOMi;
import converter.FactoryConvertI;
import converter.IConvert;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import person.Person;


public class DS_domXML1 extends ADS{

    @Override
    public void save(List<Person> lst) throws IOException
    {
        XMLEncoder e = new XMLEncoder(
                          new BufferedOutputStream(
                              new FileOutputStream(super.getfName())));
       e.writeObject(lst);
       e.close();

    }

    @Override
    public List<Person> load() throws IOException{
        
        List<Person> lst = new ArrayList<Person>();

        XMLDecoder d = new XMLDecoder(
                          new BufferedInputStream(
                              new FileInputStream(super.getfName())));
       lst = (List<Person>) d.readObject();
       d.close();
       return lst;
    }
    
}
