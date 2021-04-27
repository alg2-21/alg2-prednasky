/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *  
 */

package kralovcova.p056.dalsi;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.Scanner;
/**
 *
 * @author Jirina
 */
public class StringToByteArray {

    private static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
       // prevod textoveho retezce na pole byte v ruznem kodovani 
        String text = "nějaký text";
        byte[] a = text.getBytes(); // platform's default charset
        byte[] a_utf = text.getBytes("UTF8");
        byte[] a_uni = text.getBytes("UNICODE");
        byte[] a_ansi = text.getBytes("CP1250");
        System.out.println(text.length());
        System.out.println(a.length);
        System.out.println(a_utf.length);
        System.out.println(a_uni.length);
        System.out.println(a_ansi.length);
        
        // z pole byte na textový řetězec s využitím konkrétního kodovaní 
        // lze pouzit konstruktor třídy String
    }

}
