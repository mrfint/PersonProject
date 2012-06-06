
package view;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import view.FigureDecor1.Decor1;
import view.FigureDecor1.Decor2;
import view.correctionFigure.CorrectFigure;


class DecorChooser extends JPanel{

    public DecorChooser() {
        //setVisible(false);
        super(new GridLayout(0, 1));
        JButton b = new JButton("Decor1");
       
       ActionListener al =new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Container parent = MainFrame.curFigure.getParent();      
                JButton b = (JButton) e.getSource();
                Figure tmp= (b.getText().equals("Decor1"))? new Decor1(MainFrame.curFigure) : new Decor2(MainFrame.curFigure); 
                parent.add(tmp);
                tmp.requestFocusInWindow(); 
       
                parent.remove(MainFrame.curFigure);
                parent.repaint();
            }
        };
        b.addActionListener(al);
        add(b);
        b = new JButton("Decor2");
        b.addActionListener(al);
        add(b);
    }
    
}
