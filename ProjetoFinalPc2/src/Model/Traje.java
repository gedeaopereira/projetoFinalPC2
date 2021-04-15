package Model;

import java.util.ArrayList;

public class Traje {
    private ArrayList<Equipamento> equipamentos;
    
  public Traje(ArrayList<Equipamento> equipamentos){
      this.equipamentos = equipamentos;
  }   

    public ArrayList<Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(ArrayList<Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
    }
  
}
