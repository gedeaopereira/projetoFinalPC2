/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import View.ViewInicio;

/**
 *
 * @author gedea
 */
public class ControlInicio {

    private ViewInicio viewInicio;

    public ControlInicio() {
        this.viewInicio = new ViewInicio();
        this.viewInicio.setVisible(true);
        this.viewInicio.setLocationRelativeTo(null);
    }
    
    
}
