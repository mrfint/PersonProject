package dataStore;


import java.awt.Component;
import java.awt.Shape;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.Figure;


public class DS_domXML extends ADS{
    String[] fileExt = {"xml"};

    public DS_domXML() {
        setSuppExts(fileExt);
    }
    
    @Override
    public void save(Component comp) throws IOException {
        XMLEncoder e = new XMLEncoder(
                          new BufferedOutputStream(
                              new FileOutputStream(super.getFile())));
       
       e.writeObject(comp);
       e.close();
    }

    @Override
    public Component load() throws IOException {
        XMLDecoder d = new XMLDecoder(
                          new BufferedInputStream(
                              new FileInputStream(super.getFile())));
       Component comp = (Component) d.readObject();
       d.close();
       return comp;
    }



}
