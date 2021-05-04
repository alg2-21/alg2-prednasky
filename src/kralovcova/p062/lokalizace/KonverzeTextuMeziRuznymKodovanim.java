/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *
 */

package kralovcova.p062.lokalizace;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 *
 * @author Jirina
 */
public class KonverzeTextuMeziRuznymKodovanim {

    /**
     * @param args the command line arguments
     */
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println(System.getProperty("file.encoding"));

        String jmIn, jmOut, kodIn, kodOut;

        System.out.println("Konverze souboru v ruznem kodovani");
        System.out.println("Zadej nazev souboru ");
        jmIn = sc.nextLine();
        System.out.println("V jakem kodovani je tento soubor ");
        kodIn = sc.nextLine();

        System.out.println("Zadej nazev kopie souboru ");
        jmOut = sc.nextLine();
        System.out.println("V jakem kodovani ma byt kopie ");
        kodOut = sc.nextLine();

        InputStreamReader in = null;
        OutputStreamWriter out = null;

        try {
            in = new InputStreamReader(new BufferedInputStream(new FileInputStream(jmIn)), kodIn);
            out = new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(jmOut)), kodOut);
            int c;
            while ((c = in.read()) >= 0) {
                out.write(c);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Chyba pri otvirani vstupniho souboru");

        } catch (IOException e) {
            System.out.println("Chyba I/O pri konverzi souboru");
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
