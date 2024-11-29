/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greenshift;

import java.io.Serializable;

/**
 *
 * @author bloxd
 */
public class ClimateAction implements Serializable{
    
    String name;

    public ClimateAction(String name){
        this.name = name;
    }

    public ClimateAction() {
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return name;
    }
   
}
