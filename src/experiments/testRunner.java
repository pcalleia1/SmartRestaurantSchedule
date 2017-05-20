/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package experiments;

//import com.google.gson.Gson;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author csc190
 */
public class testRunner {

    public static void main(String[] args) {
        try {
            classA a = new classA();
            classB b = new classB();
            a.val = "instance A";
            b.val = "instance B";
            b.refA = a;
            a.refB = b;
//            Gson gson = new Gson();
//            String str = gson.toJson(a);
//            System.out.println(str);

            //use standard java serialization
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(a);
            byte[] barrOut = bos.toByteArray();
            int len = barrOut.length;
            int x = 0;
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }
}
