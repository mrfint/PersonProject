package dataStore;

import converter.FactoryConvertI;
import converter.IConvert;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import person.Person;


public class DS_YAML extends ADS{

    @Override
    public void save(List<Person> lst) throws IOException {
        FileWriter out = new FileWriter(ADS.fName);
        for(int i=0; i<lst.size(); i++){
            String type = lst.get(i).getClass().getSimpleName();
            out.write(FactoryConvertI.getInstance("yaml", type).toString(lst.get(i)));
        }
        out.close();
    }

    @Override
    public List<Person> load() throws IOException {
     
        BufferedReader in = new BufferedReader(new FileReader(ADS.fName));
        List<Person> lst = new ArrayList<Person>();
        String s; StringBuilder sb = null;
        String type = "Person";
        while((s=in.readLine())!=null)
        {   sb = new StringBuilder();
            s=in.readLine();
            while(s.charAt(3)!='*')  
            {    sb.append(s);
                 s=in.readLine();
            }
            
            lst.add(FactoryConvertI.getInstance("yaml", type).fromString(sb.toString()));
        }
        in.close();  
        return lst;
    }
    
}
