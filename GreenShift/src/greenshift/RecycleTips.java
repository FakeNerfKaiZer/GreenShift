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
// Represents a recycling tip that can be serialized for persistence.
public class RecycleTips implements Serializable {
    
    private String tipRecyle; // Stores the recycling tip.

    // Constructor to initialize a recycling tip with a specified message.
    public RecycleTips(String tipRecyle) {
        this.tipRecyle = tipRecyle;
    }

    // Default constructor for creating an empty RecycleTips object.
    public RecycleTips() {
    }

    // Returns the recycling tip.
    public String get() {
        return tipRecyle;
    }
    
    // Returns the recycling tip as a string representation.
    @Override
    public String toString() {
        return tipRecyle;
    }
}
