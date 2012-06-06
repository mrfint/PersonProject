

package view;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Dimension2D;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.colorchooser.*;


  public class ToolsPanel extends JPanel{
    private String[] capToolsShapes = {"Strelka)","Rectangle","Circle","RoundRectangle","Line"};
    private JColorChooser tcc = null;
    private JPanel panel=null;
    public ToolsPanel() {

        super(new GridLayout(0, 1));
        for (int i = 0; i < capToolsShapes.length; i++) 
        {
            XButton b = new XButton(capToolsShapes[i],i);
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    XButton but = (XButton) e.getSource();
                    MainFrame.curFigure = new Figure();
                    MainFrame.curFigure.setType(but.tag);
                    //MainFrame.curFigure.repaint();
                }
            });
            add(b);
        }
        ((XButton)getComponent(0)).setFocusPainted(false);
    }
 
    
  }