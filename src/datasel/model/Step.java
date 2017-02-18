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
public class Step implements java.io.Serializable{
    protected String name;
    protected String step;
    protected int time; //in minutes
    public Step(String inpName, String inpStep, int inpTime) {
        this.name = inpName;
        this.step = inpStep;
        this.time = inpTime;
    }
}
