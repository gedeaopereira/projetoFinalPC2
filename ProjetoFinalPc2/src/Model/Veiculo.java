package Model;

import java.util.ArrayList;

public class Veiculo {

    private String nome;
    private String tipo;
    private ArrayList<Armas> armas;

    public Veiculo(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
        this.armas = new ArrayList<>();
    }

    public Veiculo(String nome, String tipo, ArrayList<Armas> armas) {
        this.nome = nome;
        this.tipo = tipo;
        this.armas = armas;
    }

    public void adicionarArmas(Armas armas) {
        this.armas.add(armas);
    }

    public void removerArmas(String nome) {
        for (int i = 0; i < armas.size(); i++) {
            if (armas.get(i).getNome().equals(nome)) {
                armas.remove(i);
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Armas> getArmas() {
        return armas;
    }

    public void setArmas(ArrayList<Armas> armas) {
        this.armas = armas;
    }
}
