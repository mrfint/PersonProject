package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import dataStore.DSFactory;
import model.PersonModel;

public class MainFrame extends JFrame{
    
    private PersonModel tmodel;
    private JTable table;
    
    private JMenu menuFile=null;
    private JFileChooser fc = null;
    private JPanel jpTop = null;

    private String[] capMenuFileEn={"Save as..","Load...","Export to LAN","Export to DB","Import from LAN","Import from DB","Exit"};
    
    public static final int DEFAULT_WIDTH=400;
    public static final int DEFAULT_HEIGHT=500;
    
    public MainFrame(PersonModel model){
        //Create and set up the window.
        super("Persons");
        
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        
        setLocationRelativeTo(this);
        //Create MenuBar
        setJMenuBar(this.createMenuBar());
        // Set model of table
        tmodel = model;		
        //Create and set up the content pane.
        addContentPane(getContentPane());
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void addListenersMenuFile(Action[] MenuListener)
    {       
    for(int i=0; i<MenuListener.length;i++)
        {
            JMenuItem m = (JMenuItem) menuFile.getItem(i);
            m.setAction(MenuListener[i]);
        }
        
    }

    public String[] getCaptionEn() {
        return capMenuFileEn;
    }
     
    public JMenuBar createMenuBar(){
        JMenuBar menuBar;
        
       //Create the menu bar.
        menuBar = new JMenuBar();
       //Build the first menu.
        menuFile = new JMenu("File");
 
        //a group of JMenuItems
        
        for (int i = 0; i < capMenuFileEn.length; i++) {
            JMenuItem menuItem = new JMenuItem(capMenuFileEn[i]);
            menuFile.add(menuItem);
        }
        menuBar.add(menuFile);                
                      
        return menuBar;
    }

    private void addContentPane(Container contentPane) {
        
        table = new JTable();
        table.setModel(tmodel);
        
        table.setRowHeight(50);
		
	add(new JScrollPane(table));
		
	table.setDefaultEditor(String.class, null);
        
    }

    public File getFileWithAsk(String ask) 
    {   File res = null;
        //Set up the file chooser.
        if (fc == null) 
        {
            fc = new JFileChooser();
        }
        fc.setAcceptAllFileFilterUsed(true);

        //Show it.
        int returnVal = fc.showDialog(this, ask);

        //Process the results.
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            res = fc.getSelectedFile();
            if(ask.equals("Save")) JOptionPane.showMessageDialog(this, "Data is saved");
        }
        
        return res;
    }
    //Show data at the Table
    public  void showData() 
    {
            table.revalidate();
    }
    
}


