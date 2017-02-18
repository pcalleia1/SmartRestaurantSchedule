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
public class Menu implements java.io.Serializable {
    Dish [] arrDish;
    public Menu(Dish [] inpArr){
        this.arrDish = inpArr;
    }
    public Dish getDishById(String id){
        for(int i=0; i<this.arrDish.length; i++){
            if(this.arrDish[i].id.equals(id)) return this.arrDish[i];
        }
        return null;
    }
}
