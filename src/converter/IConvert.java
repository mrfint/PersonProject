package converter;

import person.Person;

public interface IConvert {
    String toString(Person o);
    Person fromString(String s);
}
