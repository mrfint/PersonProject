
package main;

import controller.Controller;
import javax.swing.JFrame;
import view.MainFrame;

public class MainClass {
    public static void main(String[] arg)
    {
        MainFrame mf = new MainFrame();
        mf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        Controller controller = new Controller(mf);
        mf.setVisible(true);
      
        
    }
}
