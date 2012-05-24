package view;



import model.fileChooser.ImageFilter;
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

public class MainFrame extends JFrame{
    private JMenu menuFile=null;
    private JFileChooser fc = null;
    private JPanel jpTop = null;

    private String[] capMenuFileEn={"New","Save as..","Load","Exit"};
    private String[] discMenuFileEn={"Clear canvas","Save file as...","Load file...","Exit application"};
 
    public static final int DEFAULT_WIDTH=1500;
    public static final int DEFAULT_HEIGHT=700;
    public static JPanel drawHolst = null;
    public static Figure curFigure = new Figure();
  
    public MainFrame(){
        //Create and set up the window.
        super("MyPaint");
        //setLocationRelativeTo(this);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        //Create MenuBar
        setJMenuBar(this.createMenuBar());
        //Create and set up the content pane.
        addContentPane(getContentPane());
        
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

    public String[] getDiscMenuFileEn() {
        return discMenuFileEn;
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
        
        //Build second menu in the menu bar.
        JMenu help = new JMenu("Help");
                
        JMenuItem about = new JMenuItem("About");
        help.add(about);
        
        menuBar.add(help);
        
                
        return menuBar;
    }

    private void addContentPane(Container contentPane) {
        
        jpTop = new JPanel(new BorderLayout());
                
                
        LeftMainPanel leftMainPanel = new LeftMainPanel();
        leftMainPanel.setPreferredSize(new Dimension(280, 60));
        jpTop.add(leftMainPanel, BorderLayout.WEST);
        // Init holst
        drawHolst = new Figure();
        drawHolst.setBackground(Color.white);
        drawHolst.setOpaque(true);
        drawHolst.setFocusable(false);
        jpTop.add(drawHolst, BorderLayout.CENTER);
        
        contentPane.add(jpTop);
        
    }

    public File getFileWithAsk(String ask) 
    {   File res = null;
        //Set up the file chooser.
        if (fc == null) 
        {
            fc = new JFileChooser();
        }
        fc.addChoosableFileFilter(new ImageFilter());
        fc.setAcceptAllFileFilterUsed(true);

        //Show it.
        int returnVal = fc.showDialog(this, ask);

        //Process the results.
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            res = fc.getSelectedFile();
        }
        return res;
    }
    
    
}


