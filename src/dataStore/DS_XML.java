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

public class DS_XML extends ADS{

    @Override
    public void save(List<Person> lst) throws IOException
    {
        FileWriter out = new FileWriter(ADS.fName);
        out.write("<document>\r\n");
        for(int i=0; i<lst.size(); i++){
            String type = lst.get(i).getClass().getSimpleName();
            out.write(FactoryConvertI.getInstance("xml", type).toString(lst.get(i)));
        }
        out.write("</document>");
        out.close();
    }

    @Override
    public List<Person> load() throws IOException{
        IConvert converter = null;
        BufferedReader in = new BufferedReader(new FileReader(ADS.fName));
        List<Person> lst = new ArrayList<Person>();
        String s = in.readLine();
       
        while(!(s=in.readLine()).equals("</document>"))
        {   String type = s.substring(1,s.indexOf('>'));
            converter = FactoryConvertI.getInstance("xml", type);
            if(converter!=null) lst.add(converter.fromString(s));
        }
        in.close();  
        return lst;
    }
    
}
