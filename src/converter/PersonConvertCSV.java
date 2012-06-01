
package converter;

import converter.util.FindField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import person.Person;


public class PersonConvertCSV implements IConvert{

    @Override
    public String toString(Person o) 
    {   StringBuilder sb = new StringBuilder();
        Person t = (Person)o; 
        sb.append("Person;");
            sb.append(t.getId()).append(';');
            sb.append(t.getFn()).append(';');
            sb.append(t.getLn()).append(';');
            sb.append(t.getAge()).append(';');
        sb.append("\r\n");
        
        return sb.toString();
    }
    
    @Override
    public Person fromString(String s) 
    {   
        String[] q= s.split(";"); 
        Person t = new Person(q[1],q[2],q[3],q[4]);

       return t;
    }

}
