package model.dataStore;

import model.converter.FactoryConvertI;
import model.converter.IConvert;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.person.Person;

public class DS_CSV extends ADS{
  
    
    @Override
    public void save(List<Person> lst) throws IOException {
        FileWriter out = new FileWriter(ADS.fName);
        for(int i=0; i<lst.size(); i++){
            String type = lst.get(i).getClass().getSimpleName();
            out.write(FactoryConvertI.getInstance("csv", type).toString(lst.get(i)));
        }
        out.close();
    }

    @Override
    public List<Person> load() throws IOException {
     
        BufferedReader in = new BufferedReader(new FileReader(ADS.fName));
        List<Person> lst = new ArrayList<Person>();
        String s;
        while((s=in.readLine())!=null)
        {   String type = s.substring(0,s.indexOf(';'));
            lst.add(FactoryConvertI.getInstance("csv", type).fromString(s));
        }
        in.close();  
        return lst;
    }

}
