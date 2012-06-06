

package view;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Dimension2D;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.colorchooser.*;


  public class LeftMainPanel extends JPanel {
    
    public LeftMainPanel() {
        super (new BorderLayout());
       
        //**************** add ToolsPanel
        add(new ToolsPanel(), BorderLayout.PAGE_START);
        
        JPanel pan = new JPanel(new GridLayout(0, 1));
        
        //**************** add ColorChooser
        pan.add(new ColorChooserPanel(), BorderLayout.PAGE_END);
        
        //**************** add StrokeChoser
        pan.add(new StrokeChooser());
        
        //**************** add StrokeChoser
        pan.add(new DecorChooser());
        
        add(pan , BorderLayout.CENTER);
         
        
        
    }
 
  }