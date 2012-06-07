
package converter;

import org.jdom.Element;
import person.Person;

class PersonConvertDomXML implements IConvertDomXML {

    public PersonConvertDomXML() {
    }

    @Override
    public Element toElement(Person o) {
        Person t= (Person)o;
        Element e = new Element(t.getClass().getSimpleName());        
        
        e.addContent(new Element("id").setText(""+t.getId()));
        e.addContent(new Element("fn").setText(t.getFn()));
        e.addContent(new Element("ln").setText(t.getLn()));
        e.addContent(new Element("age").setText(""+t.getAge()));
        e.addContent(new Element("image").setText(t.getIm()));
        e.addContent(new Element("phones").setText(""+t.getPh()));
        
        return e;
    }

    @Override
    public Person fromElement(Element e) {
        Person t = new Person(e.getChildText("id"),e.getChildText("fn"),e.getChildText("ln"),
               e.getChildText("age"), e.getChildText("image"), e.getChildText("phones"));
         return t;
    }

}
