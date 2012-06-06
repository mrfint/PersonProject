
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

public class Decor1 extends Figure{
    
    private Figure figure;
    
    public Decor1(Figure a) {
        super();
        this.figure = a;

        setBounds(figure.getX(), figure.getY(), figure.getWidth(), figure.getHeight());
        add(figure);
        
    }
    @Override
    public void paintComponent(Graphics g){
        g.setColor(Color.GREEN);
        g.drawRect(25, 25, getWidth()-50, getHeight()-50);
        figure.setBounds(0, 0, getWidth(), getHeight());
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }
   
}
