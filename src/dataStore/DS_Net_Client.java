package dataStore;


import converter.FactoryConvertI;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;
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
    private Scanner in;
    private PrintWriter out;
    private Person p;

    @Override
    public void save(List<Person> lst) throws IOException {
        
        try
        {
            s = new Socket("localhost", 8189);

            in = new Scanner(s.getInputStream());
            out = new PrintWriter(s.getOutputStream(), true );

            out.println("save");           
            for(int i=0; i<lst.size(); i++){
                p = lst.get(i);
                String type = p.getClass().getSimpleName();
                out.println(FactoryConvertI.getInstance("json", type).toString(p));
                
                if(p.getIm()!=null)
                { 
                    (new TransImage()).start();
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
    private class TransImage extends Thread{

        @Override
        public void run() {
            Socket socketIm;
            try {
                socketIm = new Socket("localhost", 8189);
                
                //BufferedReader inStreamImFile = new BufferedReader(new FileReader(p.getIm()));
                PrintWriter outIm = new PrintWriter(socketIm.getOutputStream(), true );

                outIm.println("image");
                //BufferedOutputStream imagebos = new BufferedOutputStream(socketIm.getOutputStream());  
                
                int c =0, i=0;  
                FileInputStream infile = new FileInputStream(new File("user.jpg"));  
                
                File outputFile = new File("outagain.jpg");           
                FileOutputStream outfile = new FileOutputStream(outputFile);    
                
                System.out.println("Client");     
                while((c = infile.read())!=-1){  
                    i++;    
                //    imagebos.write(c);   
                    outfile.write(c);  
                }  
                System.out.println(i+" Stuff");   
                infile.close(); 
                outfile.close();
                //imagebos.flush();  
                //imagebos.close();            
                
//                String str;
//                while((str=inStreamImFile.readLine())!=null)
//                {   
//                    outIm.println(str);
//                }
                in.close();  
                socketIm.close();
                    
            } catch (UnknownHostException ex) {
                Logger.getLogger(DS_Net_Client.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(DS_Net_Client.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
        }
        
    }
}
