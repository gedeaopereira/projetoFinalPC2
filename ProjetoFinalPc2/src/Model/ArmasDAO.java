/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author gedea
 */
public class ArmasDAO {

    private final String CAMINHO = "Armas";

    public ArrayList<Armas> ler() throws IOException, FileNotFoundException {
        ArrayList<Armas> armas = new ArrayList();
        try {
            FileReader arq = new FileReader(CAMINHO);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = "";
            try {
                linha = lerArq.readLine();
                while (linha != null) {
                    ArrayList<String> acessorios = new ArrayList<>();
                    for (String nome : linha.split(" nome: ")) {
                        for (String acessorio : nome.split(" acessorio: ")) {
                            acessorios.add(acessorio);
                        }
                        if (nome.contains(" acessorio: ")) {
                            nome = nome.substring(0, nome.indexOf(" acessorio: "));
                        }
                        Armas arma = new Armas(nome, acessorios);
                        armas.add(arma);
                    }
                    linha = lerArq.readLine();
                }
                arq.close();
                return armas;
            } catch (IOException ex) {
                throw ex;

            }
        } catch (FileNotFoundException ex) {
            throw ex;
        }
    }

    public boolean cadastra(Armas arma) {
        try {
            FileWriter arq = new FileWriter(CAMINHO, true);
            PrintWriter gravarArq = new PrintWriter(arq);

            String Texto = " nome: " + arma.getNome();
            if (arma.getAcessorios().size() > 0) {
                for (String acessorio : arma.getAcessorios()) {
                    Texto += " acessorio: " + acessorio;
                }
            } else {
                Texto = " nome: " + arma.getNome();
            }

            gravarArq.println(Texto);
            gravarArq.close();
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public String atualiza(Armas armaAtu) {
        int nContatos = 0;
        try {
            ArrayList<Armas> armasOld = ler();
            FileWriter arq = new FileWriter(CAMINHO);
            PrintWriter gravarArq = new PrintWriter(arq);
            for (Armas arma : armasOld) {
                if (!(arma.getNome().equals(armaAtu.getNome()))) {
                    String Texto = " nome: " + arma.getNome();
                    if (arma.getAcessorios().size() > 0) {
                        for (String acessorio : arma.getAcessorios()) {
                            Texto += " acessorio: " + acessorio;
                        }
                    }
                    gravarArq.println(Texto);
                    nContatos += 1;
                } else {
                    String Texto = " nome: " + armaAtu.getNome();
                    if (arma.getAcessorios().size() > 0) {
                        for (String acessorio : armaAtu.getAcessorios()) {
                            Texto += " acessorio: " + acessorio;
                        }
                    }
                    gravarArq.println(Texto);
                    nContatos += 1;
                }
            }
            gravarArq.close();
            if (nContatos == armasOld.size()) {
                return "Esse Arma não existe!";
            } else {
                return "Arma Atualizada com sucesso!";
            }
        } catch (IOException e) {
            return "Falha ao Atualizar Arma";
        }
    }

    public String deleta(Armas armaDel) {

        int nContatos = 0;
        try {
            ArrayList<Armas> armasOld = ler();
            FileWriter arq = new FileWriter(CAMINHO);
            PrintWriter gravarArq = new PrintWriter(arq);
            for (Armas arma : armasOld) {
                if (!(arma.getNome().equals(armaDel.getNome()))) {
                    String Texto = " nome: " + arma.getNome();
                    if (arma.getAcessorios().size() > 0) {
                        for (String acessorio : arma.getAcessorios()) {
                            Texto += " acessorio: " + acessorio;
                        }
                    }
                    gravarArq.println(Texto);
                    nContatos += 1;
                }
            }
            gravarArq.close();
            if (nContatos == armasOld.size()) {
                return "Esse Arma não existe!";
            } else {
                return "Arma deletada com sucesso!";
            }
        } catch (IOException e) {
            return "Falha ao deletar Arma";
        }
    }
}
