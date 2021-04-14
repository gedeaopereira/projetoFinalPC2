/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import View.ViewVeiculo;

/**
 *
 * @author gedea
 */
public class ControlVeiculo {

    private ViewVeiculo viewVeiculo;

    public ControlVeiculo() {
        this.viewVeiculo = new ViewVeiculo();
        this.viewVeiculo.setVisible(true);
        viewVeiculo.setLocationRelativeTo(null);
    }
    
    
}
