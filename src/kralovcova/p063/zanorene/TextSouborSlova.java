/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *
 */
package kralovcova.p063.zanorene;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Jirina
 */
public class TextSouborSlova {

    private static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Pocet vyskytu slov v textovem souboru");
        System.out.println("Zadej jmeno/cestu diskoveho souboru");
        String jmSoub = sc.nextLine();
        // nacteni a zpracovani zadaneho souboru
        List<Slovo> slova = new ArrayList<>();
        try (Scanner in = new Scanner(new FileInputStream(jmSoub))) {
            while (in.hasNext()) {
                String dalsiSl = in.next();
                pridejSlovo(dalsiSl.toLowerCase(), slova);
            }
        }
        System.out.println("Zadany soubor zpracovan");
        System.out.println("");
        // kontrolni vypis
        System.out.println("Celkovy pocet ruznych slov v souboru " + slova.size());
        System.out.println("Vyhledana slova");
        for (Slovo sl : slova) {
            System.out.format("%15s %4d %n", sl.slovo, sl.pocet);
        }

        // vytvoreni jmena vystupniho souboru
        // !!! vyhledat pozici posledniho separatoru v ceste k souboru
        int posLom = Math.max(jmSoub.lastIndexOf("/"), jmSoub.lastIndexOf("\\"));
        // !!! vyhledat pozici posledni tecky v ceste k souboru 
        int posT = jmSoub.lastIndexOf(".");
        int posPrip = jmSoub.length();
        if (posT >= 0 && posT > posLom) {
            posPrip = posT;
        }
        String jmSoubOut = jmSoub.substring(0, posPrip) + "_slova" + jmSoub.substring(posPrip, jmSoub.length());
        // zapis do vystupniho souboru
        System.out.println("Jmeno/cesta vystupniho souboru: " + jmSoub);
        try (PrintWriter pw = new PrintWriter(jmSoubOut)) {
            // zapsat zadane (treba i relativni) nebo kanonicke jmeno/cestu ?
            pw.println("Pocty slov v souboru: " + jmSoubOut);
            pw.format("V souboru bylo vyhledano celkem %d ruznych slov %n", slova.size());
            pw.println("Vyhledana slova");
            pw.format("%15s  %5s %n", "----------------", "-----");
            pw.format("%14s    %5s %n", "slovo", "pocet");
            pw.format("%15s  %5s %n", "----------------", "-----");
            for (Slovo sl : slova) {
                pw.format("%15s  %5d %n", sl.slovo, sl.pocet);
            }
            pw.format("%15s  %5s %n", "----------------", "-----");
        }

    }

    private static void pridejSlovo(String dalsiSl, List<Slovo> slova) {
        for (Slovo sl : slova) {
            if (sl.slovo.equalsIgnoreCase(dalsiSl)) {
                sl.zvysPocet();
                return;
            }
        }
        slova.add(new Slovo(dalsiSl));
    }

    private static class Slovo {

        String slovo;
        int pocet;

        Slovo(String slovo) {
            this.slovo = slovo;
            this.pocet = 1;
        }

        Slovo(String slovo, int pocet) {
            this.slovo = slovo;
            this.pocet = pocet;
        }

        void zvysPocet() {
            pocet++;
        }

        @Override
        public String toString() {
            return slovo + " " + pocet;
        }
    }
}
