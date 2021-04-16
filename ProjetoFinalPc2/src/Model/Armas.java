/**
 *
 * @author Matheus Shimizu, Vinicius Paiva, Gedeão Pereira Lima
 * 
 */
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
