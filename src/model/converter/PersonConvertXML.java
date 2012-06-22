
package model.converter;

import model.converter.util.FindField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.person.Person;

public class PersonConvertXML implements IConvert{

    @Override
    public String toString(Person o) 
    {   StringBuilder sb = new StringBuilder();
        Person t = (Person)o; 
        sb.append("<Person>");
            sb.append("<id>").append(t.getId()).append("</id>");
            sb.append("<fn>").append(t.getFn()).append("</fn>");
            sb.append("<ln>").append(t.getLn()).append("</ln>");
            sb.append("<age>").append(t.getAge()).append("</age>");
            sb.append("<image>").append(t.getIm()).append("</image>");
            sb.append("<phones>").append(t.getPh()).append("</phones>");
        sb.append("</Person>\r\n");
        
        return sb.toString();
    }
    
    @Override
    public Person fromString(String s) 
    {
       Person t = new Person(FindField.tagsXML(s, "id"),FindField.tagsXML(s, "fn"),FindField.tagsXML(s, "ln"), 
               FindField.tagsXML(s, "age"),FindField.tagsXML(s, "image"), FindField.tagsXML(s, "phones"));

       return t;
    }

}
