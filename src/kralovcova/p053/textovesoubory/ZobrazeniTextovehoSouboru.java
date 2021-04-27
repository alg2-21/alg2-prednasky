/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *  
 */

package kralovcova.p053.textovesoubory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author Jirina
 */
public class ZobrazeniTextovehoSouboru {

    private static Scanner sc = new Scanner(System.in);
    private static int DELKA_BLOKU = 10;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("file.encoding = " + System.getProperty("file.encoding"));
        System.out.println("");
        System.out.println("Zadej cestu k souboru");
        String jmSoub = sc.nextLine();
        // pouziti BufferedReader
        System.out.println("");
        System.out.println("Vypis 1: BufferedReder po znacich");
        try (BufferedReader br = new BufferedReader(new FileReader(jmSoub))) {
            // cteni po znacich
            int kodZnaku;
            while ((kodZnaku = br.read()) > 0) {
                char znak = (char) kodZnaku;
                //System.out.print(kodZnaku);
                System.out.print(znak);
                            }
        }
        sc.nextLine();
        
        System.out.println("");
        System.out.println("Vypis 2: BufferedReder po blocich znaku");
        try (BufferedReader br = new BufferedReader(new FileReader(jmSoub))) {
            // cteni blocich znaku
            char[] znaky = new char[DELKA_BLOKU];
            int pocet = 0;
            while ((pocet = br.read(znaky)) > 0) {
                for (int i= 0; i < pocet; i++)
                System.out.print(znaky[i]);
            }
        }
        sc.nextLine();
        
        System.out.println("");
        System.out.println("Vypis 3: BufferedReder po radcich");
        try (BufferedReader br = new BufferedReader(new FileReader(jmSoub))) {
            // cteni po radcich
            String radek;
            while ((radek = br.readLine()) != null) {
                // v promenne radek je text z dalsi radky ze souboru, a to bez "koncove sekvence"
                System.out.println(radek);
            }
        }
        sc.nextLine();
        
        // pouziti Scanner
        System.out.println("");
        System.out.println("Vypis 4: Scanner po radcich");
        //try (Scanner scSoub = new Scanner(new FileReader(jmSoub))) {
        //try (Scanner scSoub = new Scanner(new FileInputStream(jmSoub))) {
        try (Scanner scSoub = new Scanner(new File(jmSoub))) {
            // cteni po radcich
            while (scSoub.hasNext()) {
                String radek = scSoub.nextLine();
                System.out.println(radek);
            }
        }
    }

}
