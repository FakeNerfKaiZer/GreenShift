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
public class EnergyTips implements Serializable {

    String tipEnergy; // The energy-saving tip.

    // Constructor to initialize the energy tip.
    public EnergyTips(String tipEnergy) {
        this.tipEnergy = tipEnergy;
    }

    // Default constructor.
    public EnergyTips() {
    }

    // Returns the energy-saving tip.
    public String get() {
        return tipEnergy;
    }

    // Returns a string representation of the energy tip.
    @Override
    public String toString() {
        return tipEnergy;
    }
}
