
package controller.actions.menuBar;


import controller.PersonController;
import model.except.ExtenException;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import model.dataStore.DSFactory;
import view.MainFrame;

public class MenuActionLoadFromDB extends AbstractAction{
    PersonController cont = null;
     
    public MenuActionLoadFromDB(String name,  PersonController cont) {
        super(name);
        this.cont = cont;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cont.getM_model().load("storage.db"); 
      
    }

    

}
