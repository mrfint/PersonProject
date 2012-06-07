package dataStore;


import converter.FactoryConvertI;
import java.awt.Image;
import java.awt.image.BufferedImage;
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
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
                Person p = lst.get(i);
                String type = p.getClass().getSimpleName();
                out.println(FactoryConvertI.getInstance("json", type).toString(p));
                
                if(p.getIm()!=null)
                { 
                    Socket si = new Socket("localhost", 8189);
                    out.println("image");
                    
                    OutputStream os = null;
                    ImageIcon imic = new ImageIcon(p.getIm());
                    
                    BufferedImage bImage = new BufferedImage(imic.getIconWidth(),imic.getIconHeight(), BufferedImage.TYPE_INT_RGB);
                    bImage.getGraphics().drawImage(imic.getImage(), 0 , 0, null);
                    
                    bImage.getGraphics().drawImage(bImage, 0 , 0, null);
                    try {
                        os = si.getOutputStream();
                        ImageIO.write(bImage, "jpg", os);
                    } catch (IOException ex){
                        ex.printStackTrace();
                    } finally {
                        if ( os != null ){
                        try { os.close(); } catch (IOException ex){}
                    }
  }
                    
                }
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
