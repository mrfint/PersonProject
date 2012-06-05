package converter;

import org.jdom.Element;
import person.Person;

public interface IConvertDomXML {
    Element toElement(Person o);
    Person fromElement(Element e);
}
