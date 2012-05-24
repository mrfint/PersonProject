
package view.correctionFigure;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import view.Figure;

public class CorrectFigureEx extends Figure{
    
    private Figure figure;
    
    public CorrectFigureEx(Figure a) {
        this.figure = a;
        removeCorrectionPanels();
    }

    @Override
    public void focusGained(FocusEvent e) {
    }
    @Override
    public void focusLost(FocusEvent e) {
    }

    
    public void removeCorrectionPanels() {
       for(Component comp: this.getComponents()) {
            if(comp instanceof CorrectionPanel){   
                this.remove(comp);              
            }
        }
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR)); 
      
        this.repaint();
    }
    
   
}
