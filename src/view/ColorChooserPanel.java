

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
    public static Color INIT_Color = Color.black;
    
    public ColorChooserPanel() {
        super(new FlowLayout());

        //**************** add ColorChooser
        tcc = new JColorChooser();
        tcc.setPreviewPanel(new JPanel());
        tcc.getSelectionModel().addChangeListener(this);
        tcc.setBorder(BorderFactory.createTitledBorder("Choose Color"));
        tcc.setBounds(0, 0, getWidth(), getHeight());
        add(tcc);
        
    }
 
    @Override
    public void stateChanged(ChangeEvent e) {
        ColorChooserPanel.INIT_Color = tcc.getColor();
        MainFrame.curFigure.setColor(INIT_Color);
        MainFrame.curFigure.repaint();
    }
    
    
  }