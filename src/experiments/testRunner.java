/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package experiments;

import com.google.gson.Gson;

/**
 *
 * @author csc190
 */
public class testRunner {
    public static void main(String [] args){
        classA a = new classA();
        classB b = new classB();
        a.val = "instance A";
        b.val = "instance B";
        b.refA = null;
        a.refB = b;
        Gson gson = new Gson();
        String str = gson.toJson(a);
        System.out.println(str);
    }
}
