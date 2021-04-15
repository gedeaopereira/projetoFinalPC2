package Control;

import View.ViewArmas;
import Model.Armas;
import Model.ArmasDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            listAcessorios.addElement(viewArmas.getTxt_equipamentoArma().getText());
        } else if ("buscar".equals(e.getActionCommand())) {

            ArmasDAO armasDAO = new ArmasDAO();
            try {
                for (Armas arma : armasDAO.ler(this.viewArmas.getTxt_buscar().getText())) {
                    listArmas.addElement(arma.getNome());
                }
            } catch (IOException ex) {
                System.out.println("Erro ao caregar arquivo");
            }

        } else if ("excluirAcessorio".equals(e.getActionCommand())) {

            this.viewArmas.dispose();
        } else if ("novo".equals(e.getActionCommand())) {

            this.viewArmas.getTxt_equipamentoArma().setText("");
            this.viewArmas.getTxt_nomeArma().setText("");
            this.viewArmas.getBtn_salvar().setActionCommand("cadastrar");
            this.viewArmas.getBtn_salvar().setText("Cadastrar");
            this.listAcessorios.clear();

        } else if ("excluirArma".equals(e.getActionCommand())) {

            ArmasDAO armasDAO = new ArmasDAO();
            Armas armas = new Armas(this.viewArmas.getList_armas().getName());
            armasDAO.deleta(armas);
            listArmas.remove(this.viewArmas.getList_armas().getSelectedIndex());

        } else if ("cadastrar".equals(e.getActionCommand())) {
            ArmasDAO armasDAO = new ArmasDAO();
            ArrayList<String> acessorios = new ArrayList<>();
            if (listAcessorios.getSize() > 0) {
                for (int i = 0; i < listAcessorios.getSize(); i++) {
                    acessorios.add(listAcessorios.get(i).toString());
                }
                Armas armas = new Armas(this.viewArmas.getTxt_nomeArma().getText(), acessorios);
                armasDAO.cadastra(armas);
            } else {
                Armas armas = new Armas(this.viewArmas.getTxt_nomeArma().getText());
                armasDAO.cadastra(armas);
            }
            listArmas.clear();;
            try {
                for (Armas arma : armasDAO.ler()) {
                    listArmas.addElement(arma.getNome());
                }
            } catch (IOException ex) {
                System.out.println("Erro ao caregar arquivo");
            }

        } else if ("salva".equals(e.getActionCommand())) {
            ArmasDAO armasDAO = new ArmasDAO();
            ArrayList<String> acessorios = new ArrayList<>();
            if (listAcessorios.getSize() > 0) {
                for (int i = 0; i < listAcessorios.getSize(); i++) {
                    acessorios.add(listAcessorios.get(i).toString());
                }
                Armas armas = new Armas(this.viewArmas.getTxt_nomeArma().getText(), acessorios);
                armasDAO.atualiza(armas);
            } else {
                Armas armas = new Armas(this.viewArmas.getTxt_nomeArma().getText());
                armasDAO.atualiza(armas);
            }
            listArmas.clear();;

        } else if ("voltar".equals(e.getActionCommand())) {

            ControlInicio controlInicio = new ControlInicio();
            this.viewArmas.dispose();

        }
    }

}
