package Control;

import View.ViewEntrar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControlEntrar implements ActionListener {

    private ViewEntrar viewEntrar;

    public ControlEntrar() {
        this.viewEntrar = new ViewEntrar();
        this.viewEntrar.setVisible(true);
        this.viewEntrar.setLocationRelativeTo(null);
        this.viewEntrar.getBtn_entrar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (null != e.getActionCommand()) switch (e.getActionCommand()) {
            case "entrar":
                String chave = this.viewEntrar.getTxt_chave().getText();
                if (chave.length() > 0) {
                    if (chave.equals("curinga123")) {
                        ControlInicio controlInicio = new ControlInicio();
                        this.viewEntrar.dispose();
                    } else {
                        JOptionPane.showMessageDialog(viewEntrar, "Senha Incorreta!!!");
                    }
                } else {
                    JOptionPane.showMessageDialog(viewEntrar, "Digite uma senha!!");
                }   break;
            case "sair":
                viewEntrar.dispose();
                System.exit(0);
                break;
            default:
                break;
        }
    }
}
