/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greenshift;
import java.io.Serializable;

/**
 *
 * @author sambo
 */
public class EnergyTips implements Serializable{
    
    String tipEnergy;
    
    public EnergyTips(String tipEnergy){
        this.tipEnergy = tipEnergy;
    }

    public EnergyTips() {
    }

    public String get() {
        return tipEnergy;
    }
    
    @Override
    public String toString(){
        return tipEnergy;
    }
}
