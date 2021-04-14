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
public class VeiculoDAO {

    private final String CAMINHO = "Veiculo";

    public ArrayList<Veiculo> ler() throws IOException, FileNotFoundException {
        ArrayList<Veiculo> veiculos = new ArrayList();
        try {
            FileReader arq = new FileReader(CAMINHO);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = "";
            try {
                linha = lerArq.readLine();
                while (linha != null) {
                    ArrayList<Armas> armas = new ArrayList<>();
                    ArrayList<String> acessorios = new ArrayList<>();
                    for (String nomeveiculo : linha.split(" veiculo: ")) {
                        String tipo = "";
                        for (String nomeArma : nomeveiculo.split(" armas: ")) {
                            for (String acessorio : nomeArma.split(" acessorio: ")) {
                                acessorios.add(acessorio);
                            }
                            if (nomeArma.contains(" acessorio: ")) {
                                nomeArma = nomeArma.substring(0, nomeArma.indexOf(" acessorio: "));
                            }
                            Armas arma = new Armas(nomeArma, acessorios);
                            armas.add(arma);
                        }
                        if (nomeveiculo.contains(" armas: ")) {
                            nomeveiculo = nomeveiculo.substring(0, nomeveiculo.indexOf(" Tipo: "));
                            tipo = nomeveiculo.substring(nomeveiculo.indexOf(" tipo: "), nomeveiculo.indexOf(" armas: "));
                        } else {
                            tipo = nomeveiculo.substring(nomeveiculo.indexOf(" tipo: "), 0);
                        }
                        Veiculo veiculo = new Veiculo(nomeveiculo, tipo, armas);
                        veiculos.add(veiculo);
                    }
                    linha = lerArq.readLine();
                }
                arq.close();
                return veiculos;
            } catch (IOException ex) {
                throw ex;

            }
        } catch (FileNotFoundException ex) {
            throw ex;
        }
    }

    public boolean cadastra(Veiculo veiuclo) {
        try {
            FileWriter arq = new FileWriter(CAMINHO, true);
            PrintWriter gravarArq = new PrintWriter(arq);
            String Texto = " veiculo: " + veiuclo.getNome();
            Texto += " tipo: " + veiuclo.getTipo();
            if (veiuclo.getArmas().size() > 0) {
                for (Armas arma : veiuclo.getArmas()) {
                    if (arma.getAcessorios().size() > 0) {
                        Texto += " armas: " + arma.getNome();
                        for (String acessorio : arma.getAcessorios()) {
                            Texto += " acessorio: " + acessorio;
                        }
                    } else {
                        Texto = " nome: " + arma.getNome();
                    }
                }
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
                    String Texto = "";
                    if (arma.getAcessorios().size() > 0) {
                        Texto = " nome: " + armaAtu.getNome();
                        for (String acessorio : armaAtu.getAcessorios()) {
                            Texto += " acessorio: " + acessorio;
                        }
                    } else {
                        Texto = " nome: " + arma.getNome();
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
            ArrayList<Veiculo> armasOld = ler();
            FileWriter arq = new FileWriter(CAMINHO);
            PrintWriter gravarArq = new PrintWriter(arq);
            for (Armas arma : armasOld) {
                if (!(arma.getNome().equals(armaDel.getNome()))) {
                    String Texto = "";
                    if (arma.getAcessorios().size() > 0) {
                        Texto = " nome: " + arma.getNome();
                        for (String acessorio : arma.getAcessorios()) {
                            Texto += " acessorio: " + acessorio;
                        }
                    } else {
                        Texto = " nome: " + arma.getNome();
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
