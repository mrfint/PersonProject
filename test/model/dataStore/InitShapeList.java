package model.dataStore;


import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.List;


public class InitShapeList {
public static List<Shape> initList0() {
        List<Shape> list = new ArrayList<Shape>();
      
        return list;
    }

    public static List<Shape> initList1() {
        List<Shape> list = new ArrayList<Shape>();
        RoundRectangle2D.Float  o2 = new RoundRectangle2D.Float(50, 30, 90, 10, 2, 3);

        list.add(o2);
        
        return list;
    }
    
    public static List<Shape> initListM() {
        
        List<Shape> list = new ArrayList<Shape>();
            Rectangle2D.Float       o0 = new Rectangle2D.Float(10, 10, 5, 3);
            Ellipse2D.Float         o1 = new Ellipse2D.Float(100, 10, 15, 3);
            RoundRectangle2D.Float  o2 = new RoundRectangle2D.Float(50, 30, 90, 10, 2, 3);
            Ellipse2D.Float         o3 = new Ellipse2D.Float(10, 10, 15, 300);
            Line2D.Float            o4 = new Line2D.Float(100,100, 100, 100);

        list.add(o0); list.add(o1); list.add(o2); list.add(o3); list.add(o4); 
        return list;
    }
}
