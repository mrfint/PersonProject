
package view;

import javax.swing.JButton;

public class XButton extends JButton{
    public int tag = 0;

    public XButton(String name, int tag) {
        super(name);
        this.tag = tag;
    }
    
}
