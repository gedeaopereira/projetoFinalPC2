package Control;

import View.ViewVeiculo;

public class ControlVeiculo {

    private ViewVeiculo viewVeiculo;

    public ControlVeiculo() {
        this.viewVeiculo = new ViewVeiculo();
        this.viewVeiculo.setVisible(true);
        viewVeiculo.setLocationRelativeTo(null);
    }
    
    
}
