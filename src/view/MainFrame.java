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
import java.awt.event.MouseListener;
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
    private JPanel  jpFace;
    private JButton btAdd;
    private JButton btRemove;
    
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
        
        // Add Table
        // jpFace = new JPanel();
        
        table = new JTable();
        table.setModel(tmodel);
        
        table.setRowHeight(50);
		
        // Init buttons
        btAdd  = new JButton("Add");
        btRemove = new JButton("Remove");
        
        // Width buttons are same
        JPanel grid = new JPanel( new GridLayout(1, 2, 15, 0) );
        grid.add( btAdd );
        grid.add( btRemove);
 
        JPanel jpDnButtons = new JPanel( new FlowLayout() );
        jpDnButtons.add(grid);
        
        // Add table and buttons
        contentPane.add(jpDnButtons, BorderLayout.SOUTH);
        contentPane.add(new JScrollPane(table), BorderLayout.CENTER);
        
        
    }
    
    public void addAddRemoveListeners(ActionListener as, ActionListener al){
        
        btAdd.addActionListener(as);
        btRemove.addActionListener(al);
        
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


    public void addTableMouseListener(MouseListener tableMouseListener) {
        table.addMouseListener(tableMouseListener);
    }
    
    public int getTableSelectedRow(){
        return table.getSelectedRow();
    }

    public int getTableSelectedCol() {
        return table.getSelectedColumn();
    }
    
}


