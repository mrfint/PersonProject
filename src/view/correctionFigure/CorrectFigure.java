
package view.correctionFigure;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import view.Figure;
import view.MainFrame;

public class CorrectFigure extends Figure{
    
    private Figure figure;
    private MouseResizeHandler mlResize = null;
    
    public CorrectFigure(Figure a) {
        super();
        this.figure = a;
        mlResize = new MouseResizeHandler(this);
        setBounds(figure.getX(), figure.getY(), figure.getWidth(), figure.getHeight());
        addCorrectionPanels();
        add(figure);
        
    }
    @Override
    public void paintComponent(Graphics g){
        figure.setBounds(0, 0, getWidth(), getHeight());
    }
    @Override
    public void focusGained(FocusEvent e) {
    }
    @Override
    public void focusLost(FocusEvent e) {
         Container parent = getParent();
         Figure tmp = figure;

         parent.add(tmp);
         tmp.setLocation(getX(),getY());
         parent.remove(this);
         
        // MainFrame.curFigure = new Figure();
    }
    private void addCorrectionPanels() {
        for (int i = 0; i < 9; i++) {
            CorrectionPanel p = new CorrectionPanel(i);
            p.addMouseListener(mlResize);
            p.addMouseMotionListener(mlResize);
            this.add(p);
        }
        this.repaint();
    }
    
    public void updateCorrectionPanels(){
        for(Component c: this.getComponents()) {
            if(c instanceof CorrectionPanel){ 
                        ((CorrectionPanel)c).setBounds();
            }
        }
    }
 //**************************************private class   
  private class MouseResizeHandler extends MouseAdapter
    {   private CorrectFigure inn;

        private Point startPoint = null;
        private Point endPoint = null;

        public MouseResizeHandler(CorrectFigure inn) {
            this.inn = inn;
        }
        
     
    @Override
    public void mousePressed(MouseEvent e) {
        startPoint = e.getPoint();    
    } 

   
    @Override
    public void mouseDragged(MouseEvent e) {

        endPoint = e.getPoint(); 
        inn.setCursor(Cursor.getDefaultCursor());
        
        int x = inn.getX();
        int y = inn.getY();
        int w = inn.getWidth();
        int h = inn.getHeight();
        
        int dx = endPoint.x-startPoint.x;
        int dy = endPoint.y-startPoint.y;

        CorrectionPanel cp = (CorrectionPanel) e.getSource();
        
        switch(cp.getType())
        {
            case 0 : {    x+=dx; y+=dy; w-=dx; h-=dy;  break;        }
            case 1 : {    y+=dy; h-=dy;                break;        }
            case 2 : {    y+=dy; w+=dx; h-=dy;         break;        }
            case 3 : {    x+=dx; w-=dx;                break;        } 
            case 4 : {    w+=dx;                       break;        }   
            case 5 : {    x+=dx; w-=dx; h+=dy;         break;        }
            case 6 : {    h+=dy;                       break;        }   
            case 7 : {    w+=dx; h+=dy;                break;        }
            case 8 : {    x+=dx; y+=dy;                break;        }
        }
        
        inn.setBounds(x, y, w, h);
        inn.repaint();
        updateCorrectionPanels();
      }

    @Override
    public void mouseMoved(MouseEvent e) {
        CorrectionPanel cp = (CorrectionPanel) e.getSource();
        switch(cp.getType())
        {
            case 0 : { inn.setCursor(Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR));  break;   }
            case 1 : { inn.setCursor(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));   break;   }
            case 2 : { inn.setCursor(Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR));  break;   }
            case 3 : { inn.setCursor(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));   break;   } 
            case 4 : { inn.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));   break;   }   
            case 5 : { inn.setCursor(Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR));  break;   }
            case 6 : { inn.setCursor(Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR));   break;   }   
            case 7 : { inn.setCursor(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR));  break;   }
            case 8 : { inn.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));       break;   }
        }
        
    }
  
 }
}
