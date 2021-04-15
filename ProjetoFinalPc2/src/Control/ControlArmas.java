package Control;

import View.ViewArmas;
import Model.Armas;
import Model.ArmasDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;

public class ControlArmas implements ActionListener {

    private ViewArmas viewArmas;

    public ControlArmas() throws IOException {
        this.viewArmas = new ViewArmas();
        this.viewArmas.setVisible(true);
        ArmasDAO armasDAO = new ArmasDAO();
        ArrayList<String> armas = new ArrayList<>();
        for (Armas arma : armasDAO.ler()) {
            armas.add(arma.getNome());
        }
        DefaultListModel listModel = new DefaultListModel();
        listModel.addElement(armas);
        this.viewArmas.getList_armas().setModel(listModel);
        viewArmas.setLocationRelativeTo(null);
        viewArmas.getBtn_adicionarAcessorio().addActionListener(this);
        viewArmas.getBtn_buscar().addActionListener(this);
        viewArmas.getBtn_excluirAcessorio().addActionListener(this);
        viewArmas.getBtn_novo().addActionListener(this);
        viewArmas.getBtn_excluirArma().addActionListener(this);
        viewArmas.getBtn_salvar().addActionListener(this);
        viewArmas.getBtn_voltar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("adicionarAcessorio".equals(e.getActionCommand())) {
            ControlTraje controlTraje = new ControlTraje();
            this.viewArmas.dispose();
        } else if ("buscar".equals(e.getActionCommand())) {
            ControlArmas controlArmas = new ControlArmas();
            this.viewArmas.dispose();
        } else if ("excluirAcessorio".equals(e.getActionCommand())) {
            ControlArmas controlArmas = new ControlArmas();
            this.viewArmas.dispose();
        } else if ("novo".equals(e.getActionCommand())) {
            ControlArmas controlArmas = new ControlArmas();
            this.viewArmas.dispose();
        } else if ("excluirArma".equals(e.getActionCommand())) {
            ControlArmas controlArmas = new ControlArmas();
            this.viewArmas.dispose();
        } else if ("salvar".equals(e.getActionCommand())) {
            viewArmas.dispose();
            System.exit(0);
        } else if ("voltar".equals(e.getActionCommand())) {
            viewArmas.dispose();
            System.exit(0);
        }
    }

}
