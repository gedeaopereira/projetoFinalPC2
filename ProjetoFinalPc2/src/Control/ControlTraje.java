package Control;

import View.ViewTraje;

public class ControlTraje {

    private ViewTraje viewTraje;

    public ControlTraje() {
        this.viewTraje = new ViewTraje();
        this.viewTraje.setVisible(true);
        viewTraje.setLocationRelativeTo(null);
    }
}
