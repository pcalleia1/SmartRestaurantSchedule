/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasel;

import com.google.gson.Gson;
import datasel.model.Dish;
import datasel.model.Menu;
import datasel.model.Procedure;
import datasel.model.Step;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.URLEncoder;
import java.util.Base64;

/**
 *
 * @author csc190
 */
public class client {

    protected static Menu buildMenu() {
        Step[] arrStepSteak = new Step[]{
            new Step("step 1", "preheat oven", 10),
            new Step("step 2", "put steak in oven", 1),
            new Step("step 3", "wait and check temperature", 5),
            new Step("step 4", "take out steak", 1)
        };
        Step[] arrStepKungPaoChicken = new Step[]{
            new Step("s1", "marinate the chicken using oyster sauce", 30),
            new Step("s2", "put chicken in deep fryer", 10),
            new Step("s3", "take the chicken out", 1)
        };
        Procedure procSteak = new Procedure("Steak", arrStepSteak);
        Procedure procChicken = new Procedure("KungPaoChicken", arrStepKungPaoChicken);
        Dish[] arrDishes = new Dish[]{
            new Dish("101", "Steak", 29.99f, procSteak),
            new Dish("102", "KungPaoChicken", 28.99f, procChicken)
        };
        Menu menu = new Menu(arrDishes);
        return menu;
    }

    /**
     * Serialization. Convert Menu to byte array, and then encode using base64
     *
     * @param menu
     * @return
     */
    protected static String menuToStr(Menu menu) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(menu);
            byte[] barrOut = bos.toByteArray();
            byte[] b64Out = Base64.getEncoder().encode(barrOut);
            int len1 = barrOut.length;
            int len2 = b64Out.length;
            String sRet = new String(b64Out);
            sRet = URLEncoder.encode(sRet, "UTF-8");
            return sRet;
        } catch (Exception exc) {
            System.out.println(exc);
            return null;
        }
    }

    protected static String menuToJsonStr(Menu menu) {
        try {
            Gson gson = new Gson();
            String sRet = gson.toJson(menu);
            sRet = URLEncoder.encode(sRet, "UTF-8");
            return sRet;
        } catch (Exception exc) {
            System.out.println(exc);
            return null;
        }

    }

    public static void main(String[] args) {
        //String op = args[0];
        Menu menu = buildMenu();
        String menuContent = menuToStr(menu);
        String menuJson = menuToJsonStr(menu);
        int k = 0;
    }

}
