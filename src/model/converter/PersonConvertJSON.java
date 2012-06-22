
package model.converter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.person.Person;


public class PersonConvertJSON implements IConvert{

    @Override
    public String toString(Person o) 
    {   StringBuilder sb = new StringBuilder();
        Person t = (Person)o; 
        sb.append("{\"Person\": {");
            sb.append("\"id\":\"").append(t.getId()).append("\",");
            sb.append("\"fn\":\"").append(t.getFn()).append("\",");
            sb.append("\"ln\":\"").append(t.getLn()).append("\",");
            sb.append("\"age\":\"").append(t.getAge()).append("\",");
            sb.append("\"image\":\"").append(t.getIm()).append("\",");
            sb.append("\"phones\":\"").append(t.getPh()).append("\"");
        sb.append("}");
        
        return sb.toString();
    }
    
    @Override
    public Person fromString(String s) 
    {
       Person t = new Person(FindField.tagsJSON(s, "id"),FindField.tagsJSON(s, "fn"),FindField.tagsJSON(s, "ln"),
                        FindField.tagsJSON(s, "age"), FindField.tagsJSON(s, "image"), FindField.tagsJSON(s, "phones"));

       return t;
    }

}
