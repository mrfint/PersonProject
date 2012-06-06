
package view;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


class StrokeChooser extends JPanel implements ChangeListener{
    static final int FPS_MIN = 0;
    static final int FPS_MAX = 30;
    static final int FPS_INIT = 10; 
    
    public static int INIT_Stroke = 5;
    
    JSlider framesPerSecond;
    
    public StrokeChooser() 
    {
        super(new BorderLayout());
        MainFrame.curFigure.setWl(FPS_INIT);        
      
        framesPerSecond = new JSlider(JSlider.HORIZONTAL,
                                      FPS_MIN, FPS_MAX, FPS_INIT);
        setFocusable(false);

        //Turn on labels at major tick marks.
        framesPerSecond.setMajorTickSpacing(10);
        framesPerSecond.setMinorTickSpacing(1);
        framesPerSecond.setPaintTicks(true);
        framesPerSecond.setPaintLabels(true);
        setBorder(BorderFactory.createTitledBorder("Choose Stroke Line"));
        
        
        
        add(framesPerSecond, BorderLayout.PAGE_START);
        
        framesPerSecond.addChangeListener(this);

    }

        public void actionPerformed(ActionEvent e) {
            
        }

    @Override
    public void stateChanged(ChangeEvent e) {
        INIT_Stroke = framesPerSecond.getValue();
        
        MainFrame.curFigure.setWl(INIT_Stroke);
        MainFrame.curFigure.repaint();
    }
}