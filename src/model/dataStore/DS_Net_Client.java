package model.dataStore;


import model.converter.FactoryConvertI;
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
import javax.swing.JOptionPane;
import org.apache.commons.codec.binary.Base64;
import model.person.Person;


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
                
                if(p.getIm()!=null && (!p.getIm().equals("")))
                { 
                    (new TransImage(p.getId(), p.getIm())).start();
                }
            }
            System.out.println("Data is send");
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
        private final int pID;
        private final String pIM;

        private TransImage(int id, String im) {
            pID = id;
            pIM = im;
        }

        @Override
        public void run() {
            Socket socketIm;
            try {
                socketIm = new Socket("localhost", 8189);
                
                PrintWriter outIm = new PrintWriter(socketIm.getOutputStream(), true );

                outIm.println("saveImage");
                outIm.println(pID);
                
                outIm.println( picToSting(pIM) );
                
                
            } catch (UnknownHostException ex) {
                Logger.getLogger(DS_Net_Client.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(DS_Net_Client.class.getName()).log(Level.SEVERE, null, ex);
            }
                   
        }
        
    }
    
    private String picToSting(String fileName) throws IOException {
       
        File myFile = new File (fileName);
       
        byte[] mybytearray  = new byte [(int)myFile.length()];
       
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(myFile));
        bis.read(mybytearray,0,mybytearray.length);
        byte[] base64ByteArray = Base64.encodeBase64(mybytearray); 
     
        return new String(base64ByteArray);
  }
    
     private void PStringToPic(String input) throws IOException {

        File myFile = new File("newUser.jpg");

        byte[] mybytearrayTMP = input.getBytes();//"UTF-16"
        byte[] mybytearray = Base64.decodeBase64(mybytearrayTMP);//"UTF-16"
        FileOutputStream fos = new FileOutputStream(myFile);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        bos.write(mybytearray, 0, mybytearray.length);
        bos.close();

        //return encr.byteArrayToString(mybytearray);
    }

}
