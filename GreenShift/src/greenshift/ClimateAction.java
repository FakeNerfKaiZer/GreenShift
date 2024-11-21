/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greenshift;

/**
 *
 * @author bloxd
 */
public class ClimateAction {
    String name, content;
    boolean done;

    public ClimateAction(String name) {
        this.name = name;
    }

    public ClimateAction() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Todo: " + name + ", content: " + content + ", done: " + done ;
    }*/
    
    @Override
    public String toString() {
        return name;
    }
    
}
