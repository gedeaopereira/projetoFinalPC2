/**
 *
 * @author Matheus Shimizu, Vinicius Paiva, Gedeão Pereira Lima
 * 
 */

package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ArmasDAO {

    private final String CAMINHO = "Armas";

    public ArmasDAO() {
        try {
            FileWriter arq = new FileWriter(CAMINHO, true);
        } catch (IOException ex) {
            System.out.println("Erro ao caregar arquivo");
        }
    }

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
                        if (!nome.equals("")) {
                            boolean teste = false;
                            for (String acessorio : nome.split(" acessorio: ")) {
                                if (teste) {
                                    acessorios.add(acessorio);
                                }
                                teste = true;
                            }
                            if (nome.contains(" acessorio: ")) {
                                nome = nome.substring(0, nome.indexOf(" acessorio: "));
                            }
                            Armas arma = new Armas(nome, acessorios);
                            armas.add(arma);
                        }
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

    public ArrayList<Armas> ler(String busca) throws IOException, FileNotFoundException {
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
                        if (!nome.equals("")) {
                            boolean teste = false;
                            for (String acessorio : nome.split(" acessorio: ")) {
                                if (teste) {
                                    acessorios.add(acessorio);
                                }
                                teste = true;
                            }
                            if (nome.contains(" acessorio: ")) {
                                nome = nome.substring(0, nome.indexOf(" acessorio: "));
                                if (nome.contains(busca)) {
                                    Armas arma = new Armas(nome, acessorios);
                                    armas.add(arma);
                                }
                            } else if (nome.contains(busca)) {
                                Armas arma = new Armas(nome, acessorios);
                                armas.add(arma);
                            }
                        }

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

    public String atualiza(Armas armaAtu, String nomeOld) {
        int nContatos = 0;
        try {
            ArrayList<Armas> armasOld = ler();
            FileWriter arq = new FileWriter(CAMINHO, false);
            PrintWriter gravarArq = new PrintWriter(arq);
            for (Armas arma : armasOld) {
                if (!(arma.getNome().equals(nomeOld))) {
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
            FileWriter arq = new FileWriter(CAMINHO, false);
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
