package model.converter;

import org.jdom.Element;
import model.person.Person;

public interface IConvertDomXML {
    Element toElement(Person o);
    Person fromElement(Element e);
}
