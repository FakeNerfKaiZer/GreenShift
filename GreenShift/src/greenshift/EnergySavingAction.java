/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greenshift;

/**
 *
 * @author bloxd
 */
public class EnergySavingAction extends ClimateAction {

    public EnergySavingAction(String name) {
        super(name, "Pending"); // Default status is pending
    }

    @Override
    public String getActionType() {
        return "Energy Saving Action"; // Polymorphism: Action specific to energy-saving
    }

    // Override setStatus if needed
    @Override
    public void setStatus(String status) {
        super.setStatus(status);
    }
}