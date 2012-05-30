
package converter;

import converter.util.FindField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import person.Person;


public class PersonConvertYAML implements IConvert{

    @Override
    public String toString(Person o) 
    {   StringBuilder sb = new StringBuilder();
        sb.append("***Person*******************\r\n");
            sb.append("\t id : ").append(o.getId()).append("\r\n");
            sb.append("\t fn : ").append(o.getFn()).append("\r\n");
            sb.append("\t ln : ").append(o.getLn()).append("\r\n");
            sb.append("\t age : ").append(o.getAge()).append("\t\r\n");
        sb.append("****************************\r\n");
        
        return sb.toString();
    }
    
    @Override
    public Person fromString(String s) 
    {   
       String[] fields = s.split("\t");
      String[] q = new String[fields.length];
      for(int i = 1; i<fields.length; i++)
      {  String[] key =fields[i].split(":");
         q[i]=key[1].trim();
      }
      Person t = new Person(q[1],q[2],q[3],q[4]);
      return t;
    }

}
