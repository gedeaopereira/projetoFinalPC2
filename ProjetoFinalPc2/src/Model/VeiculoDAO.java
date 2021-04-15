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
                    for (String nomeVeiculo : linha.split(" veiculo: ")) {
                        String tipo = "";
                        for (String nomeArma : nomeVeiculo.split(" armas: ")) {
                            for (String acessorio : nomeArma.split(" acessorio: ")) {
                                acessorios.add(acessorio);
                            }
                            if (nomeArma.contains(" acessorio: ")) {
                                nomeArma = nomeArma.substring(0, nomeArma.indexOf(" acessorio: "));
                            }
                            Armas arma = new Armas(nomeArma, acessorios);
                            armas.add(arma);
                        }
                        if (nomeVeiculo.contains(" armas: ")) {
                            nomeVeiculo = nomeVeiculo.substring(0, nomeVeiculo.indexOf(" Tipo: "));
                            tipo = nomeVeiculo.substring(nomeVeiculo.indexOf(" tipo: "), nomeVeiculo.indexOf(" armas: "));
                        } else {
                            tipo = nomeVeiculo.substring(nomeVeiculo.indexOf(" tipo: "), 0);
                        }
                        Veiculo veiculo = new Veiculo(nomeVeiculo, tipo, armas);
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

    public ArrayList<Veiculo> ler(String busca) throws IOException, FileNotFoundException {
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
                    for (String nomeVeiculo : linha.split(" veiculo: ")) {
                        String tipo = "";
                        for (String nomeArma : nomeVeiculo.split(" armas: ")) {
                            for (String acessorio : nomeArma.split(" acessorio: ")) {
                                acessorios.add(acessorio);
                            }
                            if (nomeArma.contains(" acessorio: ")) {
                                nomeArma = nomeArma.substring(0, nomeArma.indexOf(" acessorio: "));
                            }
                            Armas arma = new Armas(nomeArma, acessorios);
                            armas.add(arma);
                        }
                        if (nomeVeiculo.contains(" armas: ")) {
                            nomeVeiculo = nomeVeiculo.substring(0, nomeVeiculo.indexOf(" Tipo: "));
                            tipo = nomeVeiculo.substring(nomeVeiculo.indexOf(" tipo: "), nomeVeiculo.indexOf(" armas: "));
                            if (nomeVeiculo.contains(busca)) {
                                Veiculo veiculo = new Veiculo(nomeVeiculo, tipo, armas);
                                veiculos.add(veiculo);
                            }
                        } else {
                            tipo = nomeVeiculo.substring(nomeVeiculo.indexOf(" tipo: "), 0);
                            if (nomeVeiculo.contains(busca)) {
                                Veiculo veiculo = new Veiculo(nomeVeiculo, tipo, armas);
                                veiculos.add(veiculo);
                            }

                        }

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

    public boolean cadastra(Veiculo veiculo) {
        try {
            FileWriter arq = new FileWriter(CAMINHO, true);
            PrintWriter gravarArq = new PrintWriter(arq);
            String Texto = " veiculo: " + veiculo.getNome();
            Texto += " tipo: " + veiculo.getTipo();
            if (veiculo.getArmas().size() > 0) {
                for (Armas arma : veiculo.getArmas()) {
                    Texto += " armas: " + arma.getNome();
                    if (arma.getAcessorios().size() > 0) {
                        for (String acessorio : arma.getAcessorios()) {
                            Texto += " acessorio: " + acessorio;
                        }
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

    public String atualiza(Veiculo veiculoAtu) {
        int nContatos = 0;
        try {
            ArrayList<Veiculo> veiculoOld = ler();
            FileWriter arq = new FileWriter(CAMINHO);
            PrintWriter gravarArq = new PrintWriter(arq);
            for (Veiculo veiculo : veiculoOld) {
                if (!(veiculo.getNome().equals(veiculoAtu.getNome()))) {
                    String Texto = " veiculo: " + veiculo.getNome();
                    Texto += " tipo: " + veiculo.getTipo();
                    if (veiculo.getArmas().size() > 0) {
                        for (Armas arma : veiculo.getArmas()) {
                            Texto += " armas: " + arma.getNome();
                            if (arma.getAcessorios().size() > 0) {
                                for (String acessorio : arma.getAcessorios()) {
                                    Texto += " acessorio: " + acessorio;
                                }
                            }
                        }
                    }
                    gravarArq.println(Texto);
                    nContatos += 1;
                } else {
                    String Texto = " veiculo: " + veiculoAtu.getNome();
                    Texto += " tipo: " + veiculoAtu.getTipo();
                    if (veiculoAtu.getArmas().size() > 0) {
                        for (Armas arma : veiculoAtu.getArmas()) {
                            Texto += " armas: " + arma.getNome();
                            if (arma.getAcessorios().size() > 0) {
                                for (String acessorio : arma.getAcessorios()) {
                                    Texto += " acessorio: " + acessorio;
                                }
                            }
                        }
                    }
                    gravarArq.println(Texto);
                    nContatos += 1;
                }
            }
            gravarArq.close();
            if (nContatos == veiculoOld.size()) {
                return "Esse Veiculo não existe!";
            } else {
                return "Veiculo Atualizado com sucesso!";
            }
        } catch (IOException e) {
            return "Falha ao Atualizar Veiculo";
        }
    }

    public String deleta(Veiculo veiculoDel) {
        int nContatos = 0;
        try {
            ArrayList<Veiculo> veiculoOld = ler();
            FileWriter arq = new FileWriter(CAMINHO);
            PrintWriter gravarArq = new PrintWriter(arq);
            for (Veiculo veiculo : veiculoOld) {
                if (!(veiculo.getNome().equals(veiculoDel.getNome()))) {
                    String Texto = " veiculo: " + veiculo.getNome();
                    Texto += " tipo: " + veiculo.getTipo();
                    if (veiculo.getArmas().size() > 0) {
                        for (Armas arma : veiculo.getArmas()) {
                            Texto += " armas: " + arma.getNome();
                            if (arma.getAcessorios().size() > 0) {
                                for (String acessorio : arma.getAcessorios()) {
                                    Texto += " acessorio: " + acessorio;
                                }
                            }
                        }
                    }
                    gravarArq.println(Texto);
                    nContatos += 1;
                }
            }
            gravarArq.close();
            if (nContatos == veiculoOld.size()) {
                return "Esse Veiculo não existe!";
            } else {
                return "Veiculo deletado com sucesso!";
            }
        } catch (IOException e) {
            return "Falha ao deletar Veiculo";
        }
    }
}
