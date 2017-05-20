/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasel;


import datasel.model.Schedule;

/**
 *
 * @author Philip Calleia
 */
public class server {
    protected static void updateSchedule(String val){
        String qry = "UPDATE tbl_schedule SET schedule='" + val +"' WHERE id='101'";
        Utils.execNonQuery(qry);
    }
    protected static String[] getEmployee(String info){
        
        String qry = "SELECT schedule FROM tbl_schedule WHERE id='101'";
        String schedObjStr = Utils.execQuery(qry);
        
        
        
        
        if((schedObjStr==null) && (schedObjStr!="dummy"))  return null;
        Schedule sched = (Schedule) Utils.toObj(schedObjStr);
        if(sched==null) return null;
        
        String[] arguments = info.split("_");
        return sched.getGuyBySchedule(arguments[0],Byte.parseByte(arguments[1]),arguments[2]);
        
    }
    public static void main(String [] args){
        String op = args[0];
        if(op.equals("uploadSchedule")){
            updateSchedule(args[1]);
        }else{
            String[] employees = getEmployee(args[1]);
            System.out.println(employees);
        }
    }
}
