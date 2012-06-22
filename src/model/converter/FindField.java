
package model.converter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindField {
    public static String tagsXML(String s, String name)
    {
       Pattern p = Pattern.compile("<"+name+">.*?</"+name+">");
       
       Matcher matcher =  p.matcher(s);
       String temp="";
       if (matcher.find()) temp=matcher.group();
       return temp.substring(name.length()+2, temp.length()-(name.length()+3));
   }
    public static String tagsJSON(String s, String name)
    {
       Pattern p = Pattern.compile("\""+name+"\".*?[,}]");
       
       Matcher matcher =  p.matcher(s);
       String temp="";
       if (matcher.find()) temp=matcher.group();
       return temp.substring(name.length()+4, temp.length()-2);
   }
    public static String tagsYAML(String s, String name)
    {
       Pattern p = Pattern.compile("\t"+name+" : .*?\r\n");
       
       Matcher matcher =  p.matcher(s);
       String temp="";
       if (matcher.find()) temp=matcher.group(); else return "";
       return temp.substring(name.length()+4, temp.length()-2);
   }
}
