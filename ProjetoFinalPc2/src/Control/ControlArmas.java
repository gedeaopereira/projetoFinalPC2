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
    private String Atualizar;

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
        viewArmas.getBtn_editar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("adicionarAcessorio".equals(e.getActionCommand())) {
            listAcessorios.addElement(viewArmas.getTxt_equipamentoArma().getText());
        } else if ("buscar".equals(e.getActionCommand())) {

            ArmasDAO armasDAO = new ArmasDAO();
            listArmas.clear();
            try {
                for (Armas arma : armasDAO.ler(this.viewArmas.getTxt_buscar().getText())) {
                    listArmas.addElement(arma.getNome());
                }
            } catch (IOException ex) {
                System.out.println("Erro ao caregar arquivo");
            }

        } else if ("excluirAcessorio".equals(e.getActionCommand())) {
            listAcessorios.remove(this.viewArmas.getList_acessorios().getSelectedIndex());
        } else if ("novo".equals(e.getActionCommand())) {

            this.viewArmas.getTxt_equipamentoArma().setText("");
            this.viewArmas.getTxt_nomeArma().setText("");
            this.viewArmas.getBtn_salvar().setActionCommand("cadastrar");
            this.viewArmas.getBtn_salvar().setText("Cadastrar");
            this.listAcessorios.clear();

        } else if ("editar".equals(e.getActionCommand())) {

            ArmasDAO armasDAO = new ArmasDAO();
            listAcessorios.clear();
            try {
                Atualizar = listArmas.get(this.viewArmas.getList_armas().getSelectedIndex()).toString();
                ArrayList<Armas> arma = armasDAO.ler(Atualizar);
                this.viewArmas.getTxt_equipamentoArma().setText("");
                this.viewArmas.getTxt_nomeArma().setText(arma.get(0).getNome());
                this.viewArmas.getBtn_salvar().setActionCommand("salva");
                this.viewArmas.getBtn_salvar().setText("Salva");
                this.listAcessorios.clear();
                for (String acessorio : arma.get(0).getAcessorios()) {
                    this.listAcessorios.addElement(acessorio);
                }
            } catch (IOException ex) {
                System.out.println("Erro ao caregar arquivo");
            }

        } else if ("excluirArma".equals(e.getActionCommand())) {

            ArmasDAO armasDAO = new ArmasDAO();
            Armas armas = new Armas(listArmas.get(this.viewArmas.getList_armas().getSelectedIndex()).toString());
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
                armasDAO.atualiza(armas, Atualizar);
            } else {
                Armas armas = new Armas(this.viewArmas.getTxt_nomeArma().getText());
                armasDAO.atualiza(armas, Atualizar);
            }
            listArmas.clear();;
            try {
                for (Armas arma : armasDAO.ler()) {
                    listArmas.addElement(arma.getNome());
                }
            } catch (IOException ex) {
                System.out.println("Erro ao caregar arquivo");
            }

        } else if ("voltar".equals(e.getActionCommand())) {

            ControlInicio controlInicio = new ControlInicio();
            this.viewArmas.dispose();

        }
    }

}
