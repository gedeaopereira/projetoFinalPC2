package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TrajeDAO {

    private final String CAMINHO = "Traje";

    public ArrayList<Traje> ler() throws IOException, FileNotFoundException {
        ArrayList<Traje> trajes = new ArrayList();
        try {
            FileReader arq = new FileReader(CAMINHO);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = "";
            try {
                linha = lerArq.readLine();
                while (linha != null) {
                    ArrayList<Armas> armas = new ArrayList<>();
                    ArrayList<String> acessorios = new ArrayList<>();
                    for (String equip : linha.split(" equip: ")) {
                        String membro = "";
                        for (String nomeArma : equip.split(" armas: ")) {
                            for (String acessorio : nomeArma.split(" acessorio: ")) {
                                acessorios.add(acessorio);
                            }
                            if (nomeArma.contains(" acessorio: ")) {
                                nomeArma = nomeArma.substring(0, nomeArma.indexOf(" acessorio: "));
                            }
                            Armas arma = new Armas(nomeArma, acessorios);
                            armas.add(arma);
                        }
                        if (equip.contains(" armas: ")) {
                            equip = equip.substring(0, equip.indexOf(" membro: "));
                            membro = equip.substring(equip.indexOf(" membro: "), equip.indexOf(" armas: "));
                        } else {
                            membro = equip.substring(equip.indexOf(" membro: "), 0);
                        }
                        Traje traje = new Traje(equip, membro, armas);
                        trajes.add(traje);
                    }
                    linha = lerArq.readLine();
                }
                arq.close();
                return trajes;
            } catch (IOException ex) {
                throw ex;

            }
        } catch (FileNotFoundException ex) {
            throw ex;
        }
    }

    public ArrayList<Traje> ler(String busca) throws IOException, FileNotFoundException {
        ArrayList<Traje> trajes = new ArrayList();
        try {
            FileReader arq = new FileReader(CAMINHO);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = "";
            try {
                linha = lerArq.readLine();
                while (linha != null) {
                    ArrayList<Armas> armas = new ArrayList<>();
                    ArrayList<String> acessorios = new ArrayList<>();
                    for (String equip : linha.split(" equip: ")) {
                        String membro = "";
                        for (String nomeArma : equip.split(" armas: ")) {
                            for (String acessorio : nomeArma.split(" acessorio: ")) {
                                acessorios.add(acessorio);
                            }
                            if (nomeArma.contains(" acessorio: ")) {
                                nomeArma = nomeArma.substring(0, nomeArma.indexOf(" acessorio: "));
                            }
                            Armas arma = new Armas(nomeArma, acessorios);
                            armas.add(arma);
                        }
                        if (equip.contains(" armas: ")) {
                            equip = equip.substring(0, equip.indexOf(" membro: "));
                            membro = equip.substring(equip.indexOf(" membro: "), equip.indexOf(" armas: "));
                            if (equip.contains(busca)) {
                                Traje traje = new Traje(equip, membro, armas);
                                trajes.add(traje);
                            }
                        } else {
                            membro = equip.substring(equip.indexOf(" membro: "), 0);
                            if (equip.contains(busca)) {
                                Traje traje = new Traje(equip, membro, armas);
                                trajes.add(traje);
                            }
                        }

                    }
                    linha = lerArq.readLine();
                }
                arq.close();
                return trajes;
            } catch (IOException ex) {
                throw ex;

            }
        } catch (FileNotFoundException ex) {
            throw ex;
        }
    }

    public boolean cadastra(Traje traje) {
        try {
            FileWriter arq = new FileWriter(CAMINHO, true);
            PrintWriter gravarArq = new PrintWriter(arq);
            String Texto = " equip: " + traje.getEquip();
            Texto += " membro: " + traje.getMembro();
            if (traje.getArmas().size() > 0) {
                for (Armas arma : traje.getArmas()) {
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

    public String atualiza(Traje trajeAtu) {
        int nContatos = 0;
        try {
            ArrayList<Traje> trajeOld = ler();
            FileWriter arq = new FileWriter(CAMINHO);
            PrintWriter gravarArq = new PrintWriter(arq);
            for (Traje traje : trajeOld) {
                if (!(traje.getEquip().equals(trajeAtu.getEquip()))) {
                    String Texto = " equip: " + traje.getEquip();
                    Texto += " membro: " + traje.getMembro();
                    if (traje.getArmas().size() > 0) {
                        for (Armas arma : traje.getArmas()) {
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
                    String Texto = " equip: " + trajeAtu.getEquip();
                    Texto += " membro: " + trajeAtu.getMembro();
                    if (trajeAtu.getArmas().size() > 0) {
                        for (Armas arma : trajeAtu.getArmas()) {
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
            if (nContatos == trajeOld.size()) {
                return "Esse equipamento não existe!";
            } else {
                return "equipamento Atualizado com sucesso!";
            }
        } catch (IOException e) {
            return "Falha ao Atualizar equipamento";
        }
    }

    public String deleta(Traje trajeDel) {
        int nContatos = 0;
        try {
            ArrayList<Traje> trajeOld = ler();
            FileWriter arq = new FileWriter(CAMINHO);
            PrintWriter gravarArq = new PrintWriter(arq);
            for (Traje traje : trajeOld) {
                if (!(traje.getEquip().equals(trajeDel.getEquip()))) {
                    String Texto = " equip: " + traje.getEquip();
                    Texto += " membro: " + traje.getMembro();
                    if (traje.getArmas().size() > 0) {
                        for (Armas arma : traje.getArmas()) {
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
            if (nContatos == trajeOld.size()) {
                return "Esse equipamento não existe!";
            } else {
                return "equipamento deletada com sucesso!";
            }
        } catch (IOException e) {
            return "Falha ao deletar equipamento";
        }
    }
}
