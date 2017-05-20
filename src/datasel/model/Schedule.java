/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasel.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author csc190
 */
public class Schedule implements java.io.Serializable {
    Employee[] arrEmployees;
    public Schedule(Employee[] inpArr){
        this.arrEmployees = inpArr;
    }
    
    public String[] getGuyBySchedule(String day, byte time, String skill){
        ArrayList<String> guys = new ArrayList<String>();
        for(int i=0; i<this.arrEmployees.length; i++){
            ArrayList<String> days = new ArrayList<String>(Arrays.asList(arrEmployees[i].days));
            ArrayList<String> skills = new ArrayList<String>(Arrays.asList(arrEmployees[i].skills));
            if ((!days.contains(day)) || (!skills.contains(skill))){
                continue;
            }
            for (int j = 0; j<arrEmployees[i].times.length; j++){
                if (arrEmployees[i].times[j]==time){
                    guys.add(arrEmployees[i].name);
                }
            }
        }
        String[] guysArr = new String[guys.size()];
        guysArr = guys.toArray(guysArr);
        return guysArr;
    }
}
