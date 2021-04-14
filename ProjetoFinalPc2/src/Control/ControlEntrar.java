
package Control;

import View.ViewEntrar;
import View.ViewInicio;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class ControlEntrar {

    private ViewEntrar viewEntrar;
    private ViewInicio viewInicio;

    public ControlEntrar() {
        this.viewEntrar = new ViewEntrar();
        this.viewEntrar.setVisible(true);
        this.viewEntrar.setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent e) {
        if("entrar".equals(e.getActionCommand())){
           String chave = this.viewEntrar.getTxt_chave().getText();
           if(chave.length() > 0){
               if(chave.equals("curinga123")){
                   this.viewInicio = new ViewInicio();
                   this.viewInicio.setVisible(true);
                   this.viewInicio.setLocationRelativeTo(null);
                   this.viewEntrar.dispose();
               }else{
                   JOptionPane.showMessageDialog(viewEntrar, "Senha Incorreta!!!");
               }
           }else{
               JOptionPane.showMessageDialog(viewEntrar, "Digite uma senha!!");
           }
        } 
}
}