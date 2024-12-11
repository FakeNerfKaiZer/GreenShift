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
    
    private String tipTransport; // Stores the transportation tip.

    // Constructor to initialize a transportation tip with a specified message.
    public TransportTips(String tipTransport) {
        this.tipTransport = tipTransport;
    }

    // Default constructor for creating an empty TransportTips object.
    public TransportTips() {
    }

    // Returns the transportation tip.
    public String get() {
        return tipTransport;
    }
    
    // Returns the transportation tip as a string representation.
    @Override
    public String toString() {
        return tipTransport;
    }
}
