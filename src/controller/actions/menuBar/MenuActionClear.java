
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
import java.awt.BorderLayout;
import java.awt.Color;
import view.Figure;
import view.MainFrame;

public class MenuActionClear extends AbstractAction{
    Controller cont = null;
     
    public MenuActionClear(String name, String descr, Controller cont) {
        super(name);
        this.cont = cont;
        putValue(SHORT_DESCRIPTION, descr);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cont.mf.drawHolst.removeAll();
        cont.mf.repaint();
        
    }

    

}
