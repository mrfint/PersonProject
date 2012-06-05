package dataStore;


import converter.FactoryConvertI;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import person.Person;


public class DS_Net_Client extends ADS{
    private Socket s = null;

    @Override
    public void save(List<Person> lst) throws IOException {
        
        try
        {
            s = new Socket("localhost", 8189);

            Scanner in = new Scanner(s.getInputStream());
            PrintWriter out = new PrintWriter(s.getOutputStream(), true );

            out.println("save");           
            for(int i=0; i<lst.size(); i++){
                String type = lst.get(i).getClass().getSimpleName();
                out.println(FactoryConvertI.getInstance("json", type).toString(lst.get(i)));
            }
            s.close();
        }
        catch(IOException e){
            System.out.println("Connection don't esteblished");
        }

    }

    @Override
    public List<Person> load() throws IOException {
        
        List<Person> lst = new ArrayList<Person>();

        try
        {
            s = new Socket("localhost", 8189);

            Scanner in = new Scanner(s.getInputStream());
            PrintWriter out = new PrintWriter(s.getOutputStream(), true );

            out.println("load");
            while (in.hasNextLine()) {
                String s = in.nextLine();
                String type = s.substring(2, s.indexOf(':')-1 );
                lst.add(FactoryConvertI.getInstance("json", type).fromString(s));
            } 

            s.close();
        }
        catch(IOException e){
            System.out.println("Connection don't esteblished");
        }
        
        return lst;
    }
}
