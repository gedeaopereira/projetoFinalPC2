package Model;
import java.util.ArrayList;

public class Equipamento {
    private String equip;
    private String membro;
    private ArrayList<Armas> armas;
    
    public Equipamento(String equip, String membro) {
        this.equip = equip;
        this.membro = membro;
        this.armas = new ArrayList<>();
    }
    
    public Equipamento (String equip, String membro, ArrayList<Armas> armas) {
        this.equip = equip;
        this.membro = membro;
        this.armas = armas;
    }
    
    public void adicionarArmas(Armas arma) {
        this.armas.add(arma);
    }

    public void removerArmas(Armas arma) {
        for(Armas a: this.armas){
            if(a.getNome().equals(arma.getNome()))
                this.armas.remove(a); 
        }
    }
    
    public String getEquip() {
        return equip;
    }

    public void setEquip(String equip) {
        this.equip = equip;
    }

    public String getMembro() {
        return membro;
    }

    public void setMembro(String membro) {
        this.membro = membro;
    }

    public  ArrayList<Armas> getArmas() {
        return armas;
    }

    public void setArmas( ArrayList<Armas> armas) {
        this.armas = armas;
    }
}
