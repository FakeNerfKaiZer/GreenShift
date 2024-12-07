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
public class TransportTips implements Serializable {
    
    String tipTransport;
    
    public TransportTips(String tipTransport){
        this.tipTransport = tipTransport;
    }

    public TransportTips() {
    }

    public String get() {
        return tipTransport;
    }
    
    @Override
    public String toString(){
        return tipTransport;
    }
}
