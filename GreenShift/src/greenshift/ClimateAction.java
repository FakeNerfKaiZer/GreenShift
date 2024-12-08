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
public class ClimateAction implements Serializable {
    
    protected String name;   // Action name
    protected String status; // Action status

    // Constructor to initialize the action.
    public ClimateAction(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return name; // Returns the action name
    }

    public String getStatus() {
        return status; // Returns the action status
    }

    public void setStatus(String status) {
        this.status = status; // Updates the action status
    }

    // Returns the type of action (can be overridden in subclasses).
    public String getActionType() {
        return "General Action";
    }

    // Returns a string representation of the action.
    @Override
    public String toString() {
        return name + " - Status: " + status;
    }
}