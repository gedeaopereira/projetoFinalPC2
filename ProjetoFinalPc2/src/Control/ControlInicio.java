package Control;

import View.ViewInicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlInicio implements ActionListener {

    private ViewInicio viewInicio;

    public ControlInicio() {
        this.viewInicio = new ViewInicio();
        this.viewInicio.setVisible(true);
        this.viewInicio.setLocationRelativeTo(null);
        this.viewInicio.getBtn_trajes().addActionListener(this);
        this.viewInicio.getBtn_armas().addActionListener(this);
        this.viewInicio.getBtn_batmovel().addActionListener(this);
        this.viewInicio.getBtn_sair().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("trajes".equals(e.getActionCommand())) {
            ControlTraje controlTraje = new ControlTraje();
            this.viewInicio.dispose();
        } else if ("armas".equals(e.getActionCommand())) {
            ControlArmas controlArmas = new ControlArmas();
            this.viewInicio.dispose();
        } else if ("batmovel".equals(e.getActionCommand())) {
            viewInicio.dispose();
            System.exit(0);
        } else if ("sair".equals(e.getActionCommand())) {
            viewInicio.dispose();
            System.exit(0);
        }
    }

}
