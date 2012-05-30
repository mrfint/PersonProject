
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
            
 
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM person");
            ResultSet result = statement.executeQuery();
            StringBuilder sb= new StringBuilder("");
            while(result.next()){
                System.out.println(result.getString(2));

            }
 
            /**
            * stmt.close();
            * При закрытии Statement автоматически закрываются
            * все связанные с ним открытые объекты ResultSet
            */
            statement.close();
        } catch (SQLException ex) {

            Logger.getLogger(DS_DB.class.getName()).log(Level.SEVERE, null, ex);
        }

            
 
        
    }

    @Override
    public List<Person> load() throws IOException {
        return lst;
    }
}
