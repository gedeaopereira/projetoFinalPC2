package Model;

import java.util.ArrayList;

public class Armas {

    private String nome;
    private ArrayList<String> acessorios;

    public Armas(String nome) {
        this.acessorios = new ArrayList<>();
        this.nome = nome;
    }
    
     public Armas(String nome, ArrayList<String> acessorios) {
        this.acessorios = acessorios;
        this.nome = nome;
    }

    public void adicionarAcessorios(String nome) {
        acessorios.add(nome);
    }

    public void removerAcessorios(String nome) {
        for (int i = 0; i < acessorios.size(); i++) {
            if(acessorios.get(i).equals(nome)){
                acessorios.remove(i);
                break;
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<String> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(ArrayList<String> acessorios) {
        this.acessorios = acessorios;
    }

}
