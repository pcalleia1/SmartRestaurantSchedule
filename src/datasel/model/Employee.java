/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasel.model;

import java.util.ArrayList;


public class Employee implements java.io.Serializable {
    public int id;
    public String name;
    public String[] skills;
    public String[] days;
    public byte[] times;
    
    public Employee(int id, String name, String[] skills, String[] days, byte[] times){
        this.id = id;
        this.name = name;
        this.skills = skills;
        this.days = days;
        this.times = times;
    }
}
