
package Control;

import View.ViewEntrar;
import java.awt.event.ActionEvent;

public class ControlEntrar {

    private ViewEntrar viewEntrar;

    public ControlEntrar() {
        this.viewEntrar = new ViewEntrar();
        this.viewEntrar.setVisible(true);
        this.viewEntrar.setLocationRelativeTo(null);
    }
    
    
    public void actionPerformed(ActionEvent e) {
        if("entrar".equals(e.getActionCommand())){
           viewEntrar.dispose();
           System.exit(0);
        } else {
  
        }
}
}