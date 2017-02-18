/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasel.model;

/**
 *
 * @author csc190
 */
public class Procedure implements java.io.Serializable {
    protected String name;
    protected Step [] arrSteps;
    public Procedure(String inpN, Step [] inpArrSteps){
        this.name = inpN;
        this.arrSteps = inpArrSteps;
    }
    public int getWaitTime(){
        int total = 0;
        for(int i=0; i<this.arrSteps.length; i++){
            total += this.arrSteps[i].time;
        }
        return total;
    }
}
