/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greenshift;

import java.io.Serializable;

/**
 *
 * @author Sean
 */
public class ClimateAction implements Serializable{
    protected String name;
    protected String status;

    public ClimateAction(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // This method can be overridden in subclasses
    public String getActionType() {
        return "General Action";
    }

    @Override
    public String toString() {
        return name + " - Status: " + status;
    }
}