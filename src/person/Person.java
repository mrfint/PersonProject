
package person;

import java.io.Serializable;

public class Person implements Comparable<Person>, Cloneable,
                                        Serializable
{
    protected int id;
    protected String fn;
    protected String ln;
    protected int age;

    public Person() {
    }
    
    
    public Person(int id, String fn, String ln, int age) {
        this.id = id;
        this.fn = fn;
        this.ln = ln;
        this.age = age;
    }
    
    public Person(String id, String fn, String ln, String age) {
        this.id = Integer.parseInt(id);
        this.fn = fn;
        this.ln = ln;
        this.age = Integer.parseInt(age);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLn() {
        return ln;
    }

    public void setLn(String ln) {
        this.ln = ln;
    }
    
    
    
    @Override
    public int compareTo(Person o){
            return this.id-o.id;
    }
    @Override 
    public boolean equals(Object o)
    {   boolean res=false;
        
        if (o instanceof Person) 
        {
            Person p = (Person)o;
            res = p.id==id && p.fn.equals(fn) && p.ln.equals(ln) && p.age==age;
        }
        return res;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", fn=" + fn + ", ln=" + ln + ", age=" + age + '}';
    }
    
}
