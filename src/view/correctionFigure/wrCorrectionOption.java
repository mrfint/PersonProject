package view.correctionFigure;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import view.Figure;


public class wrCorrectionOption {
    private final Figure figure;
    MouseResizeHandler mlResize = null;

    public wrCorrectionOption(Figure figure) {
        this.figure = figure;
        mlResize = new MouseResizeHandler();
        
    }

    public void addCorrectionPanels() {
        for (int i = 0; i < 8; i++) {
            CorrectionPanel p = new CorrectionPanel(i);
            p.addMouseListener(mlResize);
            p.addMouseMotionListener(mlResize);
            figure.add(p);
        }
        figure.repaint();
    }
    
    public void removeCorrectionPanels() {
       for(Component comp: figure.getComponents()) {
            if(comp instanceof CorrectionPanel){   
                figure.remove(comp);              
            }
        }
        figure.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR)); 
      
        figure.repaint();
    }
    
    public void updateCorrectionPanels(){
        for(Component c: figure.getComponents()) {
            if(c instanceof CorrectionPanel){ 
                        ((CorrectionPanel)c).setBounds();
            }
        }
    }
    
    
    
  private class MouseResizeHandler extends MouseAdapter
    {   
        private Point startPoint = null;
        private Point endPoint = null;
     
    @Override
    public void mousePressed(MouseEvent e) {
        startPoint = e.getPoint();    
    } 

   
    @Override
    public void mouseDragged(MouseEvent e) {

        endPoint = e.getPoint(); 
        figure.setCursor(Cursor.getDefaultCursor());
        
        int x = figure.getX();
        int y = figure.getY();
        int w = figure.getWidth();
        int h = figure.getHeight();
        
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
        }
        
        figure.setBounds(x, y, w, h);
        figure.repaint();
        updateCorrectionPanels();
      }

    @Override
    public void mouseMoved(MouseEvent e) {
        CorrectionPanel cp = (CorrectionPanel) e.getSource();
        switch(cp.getType())
        {
            case 0 : { figure.setCursor(Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR));  break;   }
            case 1 : { figure.setCursor(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));   break;   }
            case 2 : { figure.setCursor(Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR));  break;   }
            case 3 : { figure.setCursor(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));   break;   } 
            case 4 : { figure.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));   break;   }   
            case 5 : { figure.setCursor(Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR));  break;   }
            case 6 : { figure.setCursor(Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR));   break;   }   
            case 7 : { figure.setCursor(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR));  break;   }
        }
        
    }
  
 }
}
