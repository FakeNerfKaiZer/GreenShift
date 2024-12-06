/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greenshift;

/**
 *
 * @author bloxd
 */
public class RecyclingAction extends ClimateAction {

    public RecyclingAction(String name) {
        super(name, "Pending"); // Default status is Pending
    }

    @Override
    public String getActionType() {
        return "Recycling Action"; //Polymorphism: Action specific to recycling
    }

    // Override setStatus if you want to customize how the status is updated
    @Override
    public void setStatus(String status) {
        super.setStatus(status); // You can add additional logic here if needed
    }
}
