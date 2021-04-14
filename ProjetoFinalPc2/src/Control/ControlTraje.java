/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import View.ViewTraje;

/**
 *
 * @author gedea
 */
public class ControlTraje {

    private ViewTraje viewTraje;

    public ControlTraje() {
        this.viewTraje = new ViewTraje();
        this.viewTraje.setVisible(true);
        viewTraje.setLocationRelativeTo(null);
    }
}
