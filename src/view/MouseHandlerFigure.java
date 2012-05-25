/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandlerFigure extends MouseAdapter{
    private Point startPoint = null;
    private Point endPoint = null;
    private Figure fig = null;
    private Figure current;

    public MouseHandlerFigure(Figure current) {
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
            else
            {   
                endPoint = e.getPoint();
                if(current.getParent() instanceof Figure){
                     current.setLocation(current.getX()+w, current.getY()+h);
                }  
                current.invalidate();
            }
        }
     @Override
     public void mouseMoved(MouseEvent e) {
        
        current.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
     
//     @Override
//     public void mouseReleased(MouseEvent e){
//         if(MainFrame.curFigure.getType()==0){
//             requestFocusInWindow();
//         }
//     } 
  }  
