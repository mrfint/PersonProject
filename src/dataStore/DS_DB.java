
package dataStore;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import person.Person;

public class DS_DB extends ADS{
    
    private ArrayList<Person> lst = null;

    @Override
    public void save(List<Person> ls) throws IOException {

        Connection conn;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/person_db",
                    "root", "111111");
 
            Statement stat = conn.createStatement();
            stat.executeUpdate("DROP TABLE IF EXISTS Person");
            stat.executeUpdate("CREATE TABLE Person "+
                               "(id INTEGER," +
                                "fn VARCHAR(30)," +
                                "ln VARCHAR(30)," +
                                "age INTEGER" +
                                ");" );
            
            PreparedStatement prepStat = conn.prepareStatement(
                            "INSERT INTO Person VALUES (?, ?, ?, ?);");
            
            for (Person person : ls) {
                    
                prepStat.setInt(1, person.getId());
                prepStat.setString(2, person.getFn());
                prepStat.setString(3, person.getLn());
                prepStat.setInt(4, person.getAge());

                prepStat.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DS_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Person> load() throws IOException {
        List<Person> lst = new ArrayList<Person>();
        Connection conn;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/person_db",
                    "root", "111111");  
            
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM Person;");
            while (rs.next()) {
                    Person person = new Person();
                    person.setId(rs.getInt("id"));
                    person.setFn(rs.getString("fn"));
                    person.setLn(rs.getString("ln"));
                    person.setAge(rs.getInt("age"));

                    lst.add(person);
            }
        } catch (SQLException e) {
                e.printStackTrace();
        }
        
        return lst;
    }
}
