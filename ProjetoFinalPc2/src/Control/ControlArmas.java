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
    private DefaultListModel listArmas;
    private DefaultListModel listAcessorios;

    public ControlArmas() throws IOException {
        this.viewArmas = new ViewArmas();
        this.viewArmas.setVisible(true);
        ArmasDAO armasDAO = new ArmasDAO();
        listArmas = new DefaultListModel();
        listAcessorios = new DefaultListModel();
        for (Armas arma : armasDAO.ler()) {
            listArmas.addElement(arma.getNome());
        }
        this.viewArmas.getList_armas().setModel(listArmas);
        this.viewArmas.getList_acessorios().setModel(listAcessorios);
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

        } else if ("buscar".equals(e.getActionCommand())) {
            ControlArmas controlArmas = new ControlArmas();
            this.viewArmas.dispose();
        } else if ("excluirAcessorio".equals(e.getActionCommand())) {
            ControlArmas controlArmas = new ControlArmas();
            this.viewArmas.dispose();
        } else if ("novo".equals(e.getActionCommand())) {
            this.viewArmas.getTxt_equipamentoArma().setText("");
            this.viewArmas.getTxt_nomeArma().setText("");
            this.listAcessorios.clear();
        } else if ("excluirArma".equals(e.getActionCommand())) {
            ArmasDAO armasDAO = new ArmasDAO();
            Armas armas = new Armas(this.viewArmas.getList_armas().getName());
            armasDAO.deleta(armas);
            listArmas.remove(this.viewArmas.getList_armas().getSelectedIndex());
        } else if ("salvar".equals(e.getActionCommand())) {
            viewArmas.dispose();
            System.exit(0);
        } else if ("voltar".equals(e.getActionCommand())) {
            viewArmas.dispose();
            System.exit(0);
        }
    }

}
