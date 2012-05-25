
package view.correctionFigure;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

public class CorrectionPanel 
                    extends JPanel{   
    
    public final int corWIDTH  = 7;   //   Width 
    public final int corHEIGHT = 7;   //   Height 
    private int type=0;

    public int getType() {
        return type;
    }
 
    public CorrectionPanel(int type) {
        super();
        this.type = type;
        setBackground(Color.gray);
        setBounds(0, 0, corWIDTH, corHEIGHT);    
        setFocusable(true);
        
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        setBounds();
    }
    public  void setBounds(){
        int x = 0;   int y = 0;
        int w = getParent().getWidth();
        int h = getParent().getHeight();
        
        switch(getType())
        {
            case 0 : {  x = 0 ;                  y =   0;          break;     }
            case 1 : {  x = (w-corWIDTH)/2;      y =   0;          break;     }   
            case 2 : {  x = w-corWIDTH;          y =   0;          break;     }
            case 3 : {  x = 0;                   y = h/2;          break;     } 
            case 4 : {  x = w-corHEIGHT;         y = h/2;          break;     }   
            case 5 : {  x = 0;                   y = h-corHEIGHT;  break;     }
            case 6 : {  x = (w-this.corWIDTH)/2; y = h-corHEIGHT;  break;     }   
            case 7 : {  x = w-corWIDTH;          y = h-corHEIGHT;  break;     }
            case 8 : {  x = (w-corWIDTH)/2;      y = h/2;          break;     }
        }
         setBounds(x, y, corWIDTH, corHEIGHT); 
    }
}
    
