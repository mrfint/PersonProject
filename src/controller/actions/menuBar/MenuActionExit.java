
package controller.actions.menuBar;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class MenuActionExit extends AbstractAction{

    public MenuActionExit(String name) {
        super(name);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }

}
