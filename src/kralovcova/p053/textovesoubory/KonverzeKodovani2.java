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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
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
public class KonverzeKodovani2 {

    private static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        System.out.print("Zadej jméno vstupniho souboru  ");
        String jmIn = sc.nextLine();
        System.out.print("Zadej kódování vstupního souboru  ");
        String kodovaniIn = sc.nextLine();

        System.out.print("Zadej jméno výstupního souboru  ");
        String jmOut = sc.nextLine();
        System.out.print("Zadej kódování výstupního souboru ");
        String kodovaniOut = sc.nextLine();
        System.out.println();

        try (Scanner rr = new Scanner(new File(jmIn), kodovaniIn);
                PrintWriter ww = new PrintWriter(new File(jmOut), kodovaniOut)) {

            while (rr.hasNext()) {
                String radek = rr.nextLine();
                System.out.println(radek);
                ww.println(radek);
            }

        }
    }

}
