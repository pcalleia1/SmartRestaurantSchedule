/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasel;

//import com.google.gson.Gson;
import datasel.model.Employee;
import datasel.model.Schedule;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.URLEncoder;
import java.util.Base64;

/**
 *
 * @author Philip Calleia
 */
public class client {

    protected static Schedule buildSchedule() {
        Employee drEvil = new Employee(101, "Dr. Evil", new String[]{"Bu", "S", "Ba"},
                new String[]{"M", "W", "F"}, new byte[]{9, 10, 11, 12, 19, 20});
        Employee miniMe = new Employee(102, "Mini Me", new String[]{"S", "Ba"},
                new String[]{"T", "W", "F"}, new byte[]{9, 10, 12, 14, 15, 16, 17, 18});
        Employee numTwo = new Employee(103, "Number Two", new String[]{"Bu", "D"},
                new String[]{"M", "F"}, new byte[]{12, 13, 14, 15, 16, 17, 18});        
        Employee austinPow = new Employee(104, "Austin Power", new String[]{"Ba", "S"},
                new String[]{"T", "R"}, new byte[]{8, 9, 10, 11, 12, 13, 14});
        Employee[] arrEmploys = new Employee[]{drEvil, miniMe, numTwo, austinPow};
        Schedule sched = new Schedule(arrEmploys);
        return sched;
    }

//    /**
//     * Serialization. Convert Menu to byte array, and then encode using base64
//     *
//     * @param menu
//     * @return
//     */
//    protected static String menuToStr(Menu menu) {
//        try {
//            ByteArrayOutputStream bos = new ByteArrayOutputStream();
//            ObjectOutputStream oos = new ObjectOutputStream(bos);
//            oos.writeObject(menu);
//            byte[] barrOut = bos.toByteArray();
//            byte[] b64Out = Base64.getEncoder().encode(barrOut);
//            int len1 = barrOut.length;
//            int len2 = b64Out.length;
//            String sRet = new String(b64Out);
//            sRet = URLEncoder.encode(sRet, "UTF-8");
//            return sRet;
//        } catch (Exception exc) {
//            System.out.println(exc);
//            return null;
//        }
//    }



    public static void main(String[] args) {
        String op = "2";
        Schedule mySched = buildSchedule();
        String url = "http://localhost/datasel.php";
        String schedContent = Utils.toStr(mySched);
        String datastr = op.equals("1")
                ? "op=uploadSchedule&val=" + schedContent
                : "op=getEmployee&val=W_12_Bu";
        try {
            String response = Utils.httpsPost(url, datastr);
            System.out.println(response);
        } catch (Exception exc) {
            System.out.println(exc);
        }
        int k = 0;

    }

}
