/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *  
 */
package kralovcova.p051.zakladniproudy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Jirina
 */
public class KopieSouboruTryWithResources {

    private static Scanner sc = new Scanner(System.in);
    private static final int BUF_LEN = 1024;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        System.out.println("vstupni soubor");
        String jmIn = sc.nextLine();
        System.out.println("vystupni soubor");
        String jmOut = sc.nextLine();

        // try-with-resources
        try (FileInputStream fis = new FileInputStream(jmIn);
                FileOutputStream fos = new FileOutputStream(jmOut)) {

            byte[] buf = new byte[BUF_LEN];
            int pocet;
            while ((pocet = fis.read(buf)) > 0) {
                fos.write(buf, 0, pocet);
            }

            // uzavreni je zajisteno automaticky
            // "jako by"zde byl nasledujici zakomentovany k=od
            // if (fis != null) fis.close();
            // if (fos != null) fos.close();
        } catch (IOException ex) {
            System.out.println("Chyba pri praci se soubory");
        } catch (Exception ex) {
            System.out.println("Jina chyba");
            System.out.println(ex.getMessage());
        }
    }

}
