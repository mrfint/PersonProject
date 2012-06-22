package model.person;

import model.dataStore.ADS;
import model.dataStore.DSFactory;
import model.except.ExtenException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PList{
    private List<Person> lst;
    private ADS ds = null;
    
    public PList(){
        lst = new ArrayList();
        try {
            ds  = DSFactory.getInstance("store.net");
        } catch (ExtenException ex) {}
    }
    
    public void create(Person o){
        lst.add(o);
        ds.create(o);
    }
    
    public void delete(Person o){
        lst.add(o);
    }
    
    public void update(Person o){
        lst.add(o);
    }
    
    public void sort() { 
        Collections.sort(lst);  
    }

    public int size() { return lst.size();}
    
    public List<Person> getList(){return lst;}

    public void setLst(List<Person> lst) {
        this.lst = lst;
    }
    
    public String toString(){ return lst.toString();}

}