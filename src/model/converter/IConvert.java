package model.converter;

import model.person.Person;

public interface IConvert {
    String toString(Person o);
    Person fromString(String s);
}
