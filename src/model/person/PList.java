package model.person;

import model.dataStore.ADS;
import model.dataStore.DSFactory;
import model.except.ExtenException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PList{
    private List<Person> lst;
    public PList(){
        lst = new ArrayList();
    }
    public void add(Person o){
        lst.add(o);
    }
    public void sort() { 
        Collections.sort(lst);  
    }
    
    public void save() throws IOException, ExtenException {
        ADS ds = DSFactory.getInstance("xml");
        ds.save(lst);
    }

    public void load() throws IOException, ExtenException {
        ADS ds = DSFactory.getInstance("xml");
        lst = ds.load();
    }

    public int size() { return lst.size();}
    
    public List<Person> getList(){return lst;}

    public void setLst(List<Person> lst) {
        this.lst = lst;
    }
    
    public String toString(){ return lst.toString();}

}