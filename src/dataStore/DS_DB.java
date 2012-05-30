
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
            stat.executeUpdate("DROP TABLE IF EXISTS person");
            stat.executeUpdate("CREATE TABLE person "+
                               "(id INTEGER," +
                                "fn VARCHAR(30)," +
                                "ln VARCHAR(30)," +
                                "age INTEGER" +
                                ");" );
            PreparedStatement prep = conn.prepareStatement(
                            "INSERT INTO person VALUES (?, ?, ?, ?);");
            for (Person person : ls) {
                    prep.setInt(1, person.getId());
                    prep.setString(2, person.getFn());
                    prep.setString(3, person.getLn());
                    prep.setInt(4, person.getAge());
                    prep.addBatch();
            }
//            conn.setAutoCommit(false);
//            prep.executeBatch();
//            conn.setAutoCommit(true);
            
        } catch (SQLException ex) {

            Logger.getLogger(DS_DB.class.getName()).log(Level.SEVERE, null, ex);
        }

            
 
        
    }

    @Override
    public List<Person> load() throws IOException {
        return lst;
    }
}
