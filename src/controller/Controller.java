
package controller;

import controller.actions.menuBar.MenuActionClear;
import java.awt.event.ActionListener;
import java.io.File;
import javax.crypto.Mac;
import javax.swing.Action;
import controller.actions.menuBar.MenuActionExit;
import controller.actions.menuBar.MenuActionLoad;
import controller.actions.menuBar.MenuActionSaveAs;
import except.ExtenException;
import java.awt.Window;
import java.io.IOException;
import dataStore.DSFactory;
import java.awt.Component;
import view.Figure;
import view.MainFrame;

public class Controller {
    public MainFrame mf = null ;
    private Action[] arr = null;

    public Controller(MainFrame mf) {
        this.mf = mf;
        mf.addListenersMenuFile( initMenuFileListeners( mf.getCaptionEn(), mf.getDiscMenuFileEn()) );
    }
    

    private Action[] initMenuFileListeners(String[] caption, String[] disc) {
          
         arr = new  Action[caption.length]; 
            arr[0] = new MenuActionClear(caption[0], disc[0], this); 
            arr[1] = new MenuActionLoad(caption[2], disc[2], this);
            arr[2] = new MenuActionSaveAs(caption[1], disc[1], this);
            arr[3] = new MenuActionExit(caption[3], disc[3]);
         return arr;
        
    }
   
    public void loadImage(String ask) throws IOException, ExtenException {
        File f = mf.getFileWithAsk(ask);
        if(f!=null){     
            if (ask.equals("Save as..."))  {  
                DSFactory.getInstance(f).save(mf.drawHolst); 
            }
            else{      
                mf.drawHolst.removeAll();
                Figure fig = (Figure) DSFactory.getInstance(f).load();
                for(Component flst: fig.getComponents())
                {
                   mf.drawHolst.add(flst);
                }
                
                 mf.repaint();
            }
            
        }
    }

}
