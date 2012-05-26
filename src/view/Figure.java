
package view;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import view.MainFrame;
import view.correctionFigure.CorrectFigure;

public class Figure extends JPanel
                            implements Cloneable
                                        , Serializable
                                         , FocusListener{
    protected int type=1;
    private Color color=Color.black;
    private int wl=1;
    boolean f = false;

    public Figure() {
        super(null);
        
        setOpaque(false);
        addFocusListener(this);
        MouseHandler mouseHandler = new MouseHandler(this);
        addMouseListener(mouseHandler);
        addMouseMotionListener(mouseHandler);     
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        g2.setStroke(new BasicStroke(wl));
        g2.setColor(color);
        switch(type){
            case 1: { g2.draw(new Rectangle2D.Float(wl, wl, getWidth()-2*wl, getHeight()-2*wl) );  break;      }
            case 2: { g2.draw(new Ellipse2D.Float(wl, wl, getWidth()-2*wl, getHeight()-2*wl) );    break;     }
            case 3: { g2.draw(new RoundRectangle2D.Float(wl, wl, getWidth()-2*wl, getHeight()-2*wl , 10 , 10)); break; }
            case 4: { g2.draw(new Line2D.Float(wl, wl, getWidth(), getHeight()) );     break;                 }
        }
    }
    Figure tmp;
    @Override
    public void focusGained(FocusEvent e) {
       Container parent = getParent();      
       System.out.println("Focuse gained"+ getType());
       tmp= new CorrectFigure(this); 
       parent.add(tmp);
       parent.remove(this);
       parent.repaint();
    }

    @Override
    public void focusLost(FocusEvent e) {
         System.out.println("Focuse lostFig"+ getType());
         
         tmp.requestFocusInWindow();       

//         Container parent = getParent();
//         Figure tmp = ((CorrectFigure)this).getFigure();
//         parent.add(tmp);
//         tmp.setLocation(getX(),getY());
//         parent.remove(this);
//
//         parent.repaint(); 
    }
    
        
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getWl() {
        return wl;
    }

    public void setWl(int wl) {
        this.wl = wl;
    }
    
    public Object clone() {
        Figure cln=null;
       
            cln = new Figure();
           
            cln.setColor(color);
            cln.setWl(wl);
            cln.setType(type);

        return cln;
    }
//********************************private class    
private class MouseHandler extends MouseAdapter{
    private Point startPoint = null;
    private Point endPoint = null;
    private Figure fig = null;
    private Figure current;

    public MouseHandler(Figure current) {
        this.current = current;
    }
       
    @Override
    public void mousePressed(MouseEvent e) {
         startPoint = e.getPoint();
         
         if(MainFrame.curFigure.getType()!=0) 
         {   fig = (Figure) MainFrame.curFigure.clone();
             current.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
         }
         else
         {   
             System.out.println("Clac");
             current.requestFocusInWindow();
             current.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
         }
    }
     @Override
        public void mouseDragged(MouseEvent e) {
            
            endPoint = e.getPoint();
            
            int w = endPoint.x - startPoint.x;
            int h = endPoint.y - startPoint.y;   
            if(MainFrame.curFigure.getType()!=0)
            {
                fig.setBounds(startPoint.x, startPoint.y, w, h);
                current.add(fig);
            }

        }
     @Override
     public void mouseMoved(MouseEvent e) {
        
        current.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

  }  
}
