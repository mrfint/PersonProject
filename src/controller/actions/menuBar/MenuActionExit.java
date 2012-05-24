
package controller.actions.menuBar;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class MenuActionExit extends AbstractAction{

    public MenuActionExit(String name, String desc) {
        super(name);
        putValue(SHORT_DESCRIPTION, desc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }

}
