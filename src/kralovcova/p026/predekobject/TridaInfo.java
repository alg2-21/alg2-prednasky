/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *  
 */
package kralovcova.p026.predekobject;

import java.util.Scanner;

/**
 *
 * @author Jirina
 */
public class TridaInfo {

    private static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // runtime informace o tride objektu
        String str = "";
        Class tridaObjektu = str.getClass();
        System.out.println("Objekt typu String");
        System.out.println(tridaObjektu.getName());
        System.out.println(tridaObjektu.getSimpleName());
        System.out.println(tridaObjektu.getCanonicalName());
        System.out.println(tridaObjektu.getPackage().getName());
        System.out.println(tridaObjektu.getSuperclass().getName());
        System.out.println("");
        
//        byte[] b = {1, 2, 3};
//        System.out.println("Pole typu byte: " + b.getClass().getName());
//        System.out.println("");
//        
//        int[][] vektory= {{5, 8, 7}, {7, 1}, {12, 6}};
//        System.out.println("Pole typu int: " + vektory.getClass().getName());
//        System.out.println("");
        
        // runtime informace o tride/typu
        System.out.println("String: " + String.class.getName());
        System.out.println("short: " + short.class.getName());
        System.out.println("int[]: " + int[].class.getName());
        System.out.println("");
//        
       
    }

}
