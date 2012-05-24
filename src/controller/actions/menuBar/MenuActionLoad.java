
package controller.actions.menuBar;


import controller.Controller;
import except.ExtenException;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import dataStore.DSFactory;
import view.MainFrame;

public class MenuActionLoad extends AbstractAction{
    Controller cont = null;
     
    public MenuActionLoad(String name, String descr, Controller cont) {
        super(name);
        this.cont = cont;
        putValue(SHORT_DESCRIPTION, descr);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            cont.loadImage("Load");
        } catch (IOException ex) {
            Logger.getLogger(MenuActionLoad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExtenException ex) {
            Logger.getLogger(MenuActionLoad.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    

}
