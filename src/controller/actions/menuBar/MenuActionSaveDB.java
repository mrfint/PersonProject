
package controller.actions.menuBar;

import controller.PersonController;
import except.ExtenException;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import dataStore.DSFactory;

public class MenuActionSaveDB extends AbstractAction{
    PersonController cont = null;
    public MenuActionSaveDB(String name, PersonController cont) {
        super(name);
        this.cont = cont;
    }
    //Handle save button action.
    @Override
    public void actionPerformed(ActionEvent e) {
        cont.getM_model().save("storage.db"); 
        cont.getM_view().showData();     
       
    }

}
