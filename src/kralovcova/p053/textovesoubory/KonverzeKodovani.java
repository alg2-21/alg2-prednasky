/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *  
 */
package kralovcova.p053.textovesoubory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 *
 * @author Jirina
 */
public class KonverzeKodovani {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     * @throws java.io.UnsupportedEncodingException
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException, IOException {

        System.out.print("Zadej jméno vstupniho souboru  ");
        String jmIn = sc.nextLine();
        System.out.print("Zadej kódování vstupního souboru  ");
        String kodovaniIn = sc.nextLine();
        
        System.out.print("Zadej jméno výstupního souboru  ");
        String jmOut = sc.nextLine();
        System.out.print("Zadej kódování výstupního souboru ");
        String kodovaniOut = sc.nextLine();
        System.out.println();

        try (BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(jmIn), kodovaniIn));
             BufferedWriter w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(jmOut), kodovaniOut))) {
            String text;
            while ((text = r.readLine()) != null) {
                System.out.println(text);
                w.write(text);
                w.newLine();
            }
        }

    }

}
