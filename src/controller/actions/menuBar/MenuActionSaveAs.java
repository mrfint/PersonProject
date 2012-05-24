
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

public class MenuActionSaveAs extends AbstractAction{
    Controller cont = null;
    public MenuActionSaveAs(String name, String desc, Controller cont) {
        super(name);
        this.cont = cont;
        putValue(SHORT_DESCRIPTION, desc);
    }
    //Handle save button action.
    @Override
    public void actionPerformed(ActionEvent e) {
              
        try {
            cont.loadImage("Save as...");
        } catch (IOException ex) {
            Logger.getLogger(MenuActionLoad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExtenException ex) {
            Logger.getLogger(MenuActionLoad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
