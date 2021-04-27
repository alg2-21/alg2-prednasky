/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *
 */
package kralovcova.p055.javanio;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Jirina
 */
public class CteniTextovehoSouboru {

    private static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Implicitni kodovani");
        System.out.println(System.getProperty("file.encoding"));
        System.out.println("");
        System.out.println("Zadej jmeno vstupniho textoveho souboru");
        String jmSoub = sc.nextLine();
        System.out.println("Zadej kodovani souboru");
        String kodIn = sc.nextLine();

        Path pathSoub = Paths.get(jmSoub);

        // nacte bajty ze souboru do pole byte[]
        System.out.println("Nactene bajty, prevedene na text");
        try {
            byte[] bajtyZeSouboru = Files.readAllBytes(pathSoub);
            String textZeSouboru = new String(bajtyZeSouboru, kodIn);
            System.out.print(textZeSouboru);
            System.out.println();
        } catch (Exception ex) {
            System.out.println("chyba - nepodarilo se");
            System.out.println("chyba " + ex.getClass().getCanonicalName());
            System.out.println("chyba " + ex.getMessage());
        }

        // nacte radky z textoveho souboru v implicitnim kodovani
        System.out.println("");
        System.out.println("Nacteni textu v implicitnim kodovani");
        List<String> radkyZeSouboru;
        try {
            radkyZeSouboru = Files.readAllLines(pathSoub);
            for (String ra : radkyZeSouboru) {
                System.out.println(ra);
            }
        } catch (Exception ex) {
            System.out.println("chyba - nepodarilo se");
            System.out.println("chyba " + ex.getClass().getCanonicalName());
            System.out.println("chyba " + ex.getMessage());
        }

        // nacte radky z textoveho souboru v zadanem kodovani
        System.out.println("");
        System.out.println("Nacteny text v zadanem kodovani");
        try {
            radkyZeSouboru = Files.readAllLines(pathSoub, Charset.forName(kodIn));
            for (String ra : radkyZeSouboru) {
                System.out.println(ra);
            }
        } catch (Exception ex) {
            System.out.println("chyba - nepodarilo se");
            System.out.println("chyba " + ex.getClass().getCanonicalName());
            System.out.println("chyba " + ex.getMessage());
        }

        // ziskani objektu BufferedReader pro cteni ze zadaneho souboru
        System.out.println("");
        System.out.println("Otevreno pro cteni v zadanem kodovani, cteni po radcich");
        try (BufferedReader br = Files.newBufferedReader(pathSoub, Charset.forName(kodIn))) {
            String radek;
            while ((radek = br.readLine()) != null) {
                System.out.println(radek);
            }
        } catch (Exception ex) {
            System.out.println("chyba - nepodarilo se");
            System.out.println("chyba " + ex.getClass().getCanonicalName());
            System.out.println("chyba " + ex.getMessage());
        }

    }

}
