package controller;

import controller.actions.menuBar.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Action;
import javax.swing.ImageIcon;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.table.PersonModel;
import view.MainFrame;


public class PersonController {
	
    private PersonModel m_model;
    private MainFrame m_view;
    private Action[] arr = null;

    List<String> res = new ArrayList<String>();
    String [] item = null;

    public PersonController (PersonModel model, MainFrame view)
    {
        m_model = model;
        m_view  = view;

        m_view.addListenersMenuFile( initMenuFileListeners( m_view.getCaptionEn() ) );

        m_view.addAddRemoveListeners(
                new ActionListener() {
                    // *********** AddRowListener
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        m_model.addRow();
                    }
                }, new ActionListener() {
                    // *********** DeleteRowListener
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        m_model.deleteRow(m_view.getTableSelectedRow());
                    }
                });

        m_view.addTableMouseListener(new MouseAdapter() {
                    // *********** MouseClickImageListener
                    @Override
                    public void mouseClicked(MouseEvent e)
                    {
                        if ((e.getClickCount() == 2) &&  
                                (m_view.getTableSelectedCol() == m_model.PI_COL))
                        {
                            File filename = m_view.getFileWithAsk("Load");
                            if(filename!=null){
                                m_model.setValueImage(filename.toString(), m_view.getTableSelectedRow(), m_model.PI_COL);
                            }
                        }
                    }
        });
    }

    private Action[] initMenuFileListeners(String[] captionEn) {
         arr = new  Action[captionEn.length]; 
            arr[0] = new MenuActionSaveAs (captionEn[0], this);
            arr[1] = new MenuActionLoad   (captionEn[1], this);
            arr[2] = new MenuActionSaveLAN(captionEn[2], this);
            arr[3] = new MenuActionSaveDB (captionEn[3], this);
            arr[4] = new MenuActionLoadFromLAN(captionEn[4], this);
            arr[5] = new MenuActionLoadFromDB (captionEn[5], this);
            arr[6] = new MenuActionExit  (captionEn[6]);
         return arr;
    }

    public PersonModel getM_model() {
        return m_model;
    }

    public MainFrame getM_view() {
        return m_view;
    }
}


