

package view;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Dimension2D;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.colorchooser.*;


  public class ColorChooserPanel extends JPanel 
                                implements ChangeListener{
    
    private JColorChooser tcc = null;

    public ColorChooserPanel() {
        super(new FlowLayout());
        //**************** add ColorChooser
        tcc = new JColorChooser();
        tcc.setPreviewPanel(new JPanel());
        tcc.getSelectionModel().addChangeListener(this);
        setBorder(BorderFactory.createTitledBorder("Choose Color"));
        tcc.setFocusable(false);
        tcc.setBounds(0, 0, getWidth(), getHeight());
        add(tcc);
        
    }
 
    @Override
    public void stateChanged(ChangeEvent e) {
        MainFrame.curFigure.setColor(tcc.getColor());
        
    }
    
    
  }