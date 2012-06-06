package dataStore;

import converter.PersonConvertCSV;
import java.io.IOException;
import person.PList;
import person.Person;


class PersonMain{
    public static PList initList0() {
        PList list = new PList();
      
        return list;
    }

    public static PList initList1() {
        PList list = new PList();
        PersonConvertCSV t = new PersonConvertCSV();
       
        Person o = new Person(0,"Gary","Portman",30,"","");
        list.add(o);
        
        return list;
    }
    
    public static PList initListM() {
        PList list = new PList();
        PersonConvertCSV t = new PersonConvertCSV();
       
        Person o = new Person(0,"Gary","Portman",30,"","");
        Person o1 = new Person(1,"Nick","Portman",32,"","");
        Person o2 = new Person(2,"Mary","Richman",28,"","");
        Person o3 = new Person(3,"Bony","Galler",25,"","");
        Person o4 = new Person(4,"Mike","Talor",22,"","");

         list.add(o); list.add(o1); list.add(o2); list.add(o3); list.add(o4); 
        return list;
    }
   
}