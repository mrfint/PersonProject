
package view.FigureDecor1;

import view.correctionFigure.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import view.Figure;

public class Decor2 extends Figure{
    
    private Figure figure;
    
    public Decor2(Figure a) {
        super();
        this.figure = a;
        
        setBackground(Color.red);
        setBounds(figure.getX(), figure.getY(), figure.getWidth(), figure.getHeight());
        add(figure);
    }
    @Override
    public void paintComponent(Graphics g){
        g.setColor(Color.RED);
        g.drawLine(0, 0, getWidth(), getHeight());
        g.drawLine(getWidth(), 0, 0, getHeight());
        figure.setBounds(0, 0, getWidth(), getHeight());
    }
   
}
