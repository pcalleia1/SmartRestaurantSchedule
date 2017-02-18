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
public class Dish implements java.io.Serializable{
    protected String id;
    protected String name;
    protected float price;
    protected Procedure proc;
    public Dish(String inpId, String inpName, float inpPrice, Procedure inpProc){
        this.id = inpId;
        this.name = inpName;
        this.price = inpPrice;
        this.proc = inpProc;
    }
    public Procedure getProcedure(){
        return this.proc;
    }
    
}
