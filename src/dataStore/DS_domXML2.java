package dataStore;

import converter.FactoryConvertDOMi;
import converter.FactoryConvertI;
import converter.IConvert;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import person.Person;


public class DS_domXML2 extends ADS{

    @Override
    public void save(List<Person> lst) throws IOException
    {
        Document doc = new Document(new Element("document"));
        List<Element> lstEl=new ArrayList<Element>();
        for(int i=0; i<lst.size();i++)
        {
            String type=lst.get(i).getClass().getSimpleName();
            lstEl.add(FactoryConvertDOMi.getInstance(type).toElement(lst.get(i)));
        }
        doc.getRootElement().setContent(lstEl);
        XMLOutputter out = new XMLOutputter();
        out.output(doc, new FileWriter(super.getfName()));
    }

    @Override
    public List<Person> load() throws IOException{
        IConvert converter = null;
        SAXBuilder bulder = new SAXBuilder();
        List<Person> lst = new ArrayList<Person>();

        Document doc = null;
        try {
            doc = bulder.build(super.getfName());
        } catch (JDOMException ex) {
            Logger.getLogger(DS_domXML2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Element rootElement = doc.getRootElement();
        
        List lstElements =rootElement.getChildren();
        
        for (int i = 0; i < lstElements.size(); i++) 
        {
           Element el = (Element)lstElements.get(i);
           lst.add(FactoryConvertDOMi.getInstance(el.getName()).fromElement(el));
                  
        }
        return lst;
    }
    
}
