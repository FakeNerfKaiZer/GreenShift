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
public class RecycleTips implements Serializable {
    
    String tipRecyle;
    
    public RecycleTips(String tipRecyle){
        this.tipRecyle = tipRecyle;
    }

    public RecycleTips() {
    }

    public String get() {
        return tipRecyle;
    }
    
    @Override
    public String toString(){
        return tipRecyle;
    }
}
