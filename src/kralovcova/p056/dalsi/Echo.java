/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *  
 */
package kralovcova.p056.dalsi;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 *
 * @author Jirina
 */
public class Echo {

    private static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
      
        System.out.println("Nastavene kodovani");
        System.out.println("file.encoding = " + System.getProperty("file.encoding"));
        System.out.println("sun.jnu.encoding = " + System.getProperty("sun.jnu.encoding"));
        
        System.out.println("sun.stdout.encoding = " + System.getProperty("sun.stdout.encoding"));
        System.out.println("sun.stderr.encoding = " + System.getProperty("sun.stderr.encoding"));
        System.out.println("sun.desktop = " + System.getProperty("sun.desktop"));
       
        System.out.println("Charset.defaultCharset() = " + Charset.defaultCharset());
        
        String radek;
        System.out.println("Echo textoveho retezce na stdout");
        while (!(radek = sc.nextLine()).equals("")) {
            System.out.println(radek);

        }
        System.out.println("");

        String kodovaniOut = "CP1250";
        System.out.println("Kodovani vystupu " + kodovaniOut+ " nebo zadej jine:");
        radek = sc.nextLine();
        if (radek.length() > 0) {
            kodovaniOut = radek;
        }
        PrintStream newOut = new PrintStream(System.out, true, kodovaniOut);
        System.out.println("Echo textového řetězce na stdout, vystup v " + kodovaniOut);
        while (!(radek = sc.nextLine()).equals("")) {
            System.out.println(radek);

        }
        System.out.println("");
        
        String kodovaniIn = "CP1250";
        System.out.println("Kodovani vstupu " + kodovaniIn + " nebo zadej jine:");
        radek = sc.nextLine();
        if (radek.length() > 0) {
            kodovaniIn = radek;
        }
        sc = new Scanner(new InputStreamReader(System.in, kodovaniIn));
        //sc = new Scanner(System.in, kodovaniIn);
        System.out.println("Echo textoveho retezce na stdout");
        System.out.println("   Vstup v  " + kodovaniIn);
        System.out.println("   Vystup v " + kodovaniOut);
        while (!(radek = sc.nextLine()).equals("")) {
            System.out.println(radek);
        }
        System.out.println("");
        
    }

}
