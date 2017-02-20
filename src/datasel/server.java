/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasel;

import datasel.model.Dish;
import datasel.model.Menu;
import datasel.model.Procedure;

/**
 *
 * @author csc190
 */
public class server {
    protected static void updateMenu(String val){
        String qry = "UPDATE objects SET val='" + val +"' WHERE name='menu'";
        Utils.execNonQuery(qry);
    }
    protected static int getDishTime(String id){
        //1. retrieve all menu
        String qry = "SELECT val FROM objects WHERE name='menu'";
        String menuObjStr = Utils.execQuery(qry);
        Menu menu = (Menu) Utils.toObj(menuObjStr);
        Dish dish = menu.getDishById(id);
        if(dish==null) return -1;
        Procedure proc = dish.getProcedure();
        if(proc==null) return -1;
        return proc.getWaitTime();
    }
    public static void main(String [] args){
        String op = args[0];
        if(op.equals("uploadMenu")){
            updateMenu(args[1]);
        }else{
            int time = getDishTime(args[1]);
            System.out.println(time);
        }
    }
}
