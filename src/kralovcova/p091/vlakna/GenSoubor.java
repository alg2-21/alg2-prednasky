/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *
 */
package kralovcova.p091.vlakna;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author Jirina
 */
public class GenSoubor {

    private static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Zadej nazev souboru ");
        String jms = sc.nextLine();
        System.out.println("Zadej pocet cisel zapisovanych do souboru");
        long pocetCisel = sc.nextLong();
        System.out.println("Zadej maximalni hodnotu cisel");
        short maxHodnota = sc.nextShort();

        long t1 = System.currentTimeMillis();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(jms))) {
            bw.write("" + maxHodnota);
            bw.newLine();
            bw.write("" + pocetCisel);
            bw.newLine();
            for (long i = 1; i <= pocetCisel; i++) {
                short cislo = (short) (Math.random() * maxHodnota);
                bw.write(cislo + " ");
                if (i % 10 == 0) {
                    bw.newLine();
                }
            }
        }
        long t2 = System.currentTimeMillis();
        System.out.println("Vytvoreni souboru trvalo " + (t2 - t1) + " ms");

        int pocetNul;

        t1 = System.currentTimeMillis();
        try (BufferedReader cteni2 = new BufferedReader(new FileReader(jms))) {
            pocetNul = 0;
            String radek;
            String[] slova;
            while ((radek = cteni2.readLine()) != null) {
                slova = radek.split(" +");
                for (String slovo : slova) {
                    if (Integer.parseInt(slovo) == 0) {
                        pocetNul++;
                    }
                }
            }
        }
        t2 = System.currentTimeMillis();
        System.out.println(pocetNul + " nul");
        System.out.println("BufferedReader : cteni souboru trvalo " + (t2 - t1) + " ms");

        t1 = System.currentTimeMillis();
        try (Scanner cteni = new Scanner(new FileInputStream(jms))) {
            pocetNul = 0;
            while (cteni.hasNext()) {
                int cislo = cteni.nextInt();
                if (cislo == 0) {
                    pocetNul++;
                }
            }
        }
        t2 = System.currentTimeMillis();
        System.out.println(pocetNul + " nul");
        System.out.println("Scanner : cteni souboru trvalo " + (t2 - t1) + " ms");

    }

}
