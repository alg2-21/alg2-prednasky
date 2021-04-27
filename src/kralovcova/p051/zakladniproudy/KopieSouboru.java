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
public class KopieSouboru {

    private static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        System.out.println("vstupni soubor");
        String jmIn = sc.nextLine();
        System.out.println("vystupni soubor");
        String jmOut = sc.nextLine();

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(jmOut);
            fis = new FileInputStream(jmIn);

            int nactenyByte;
            while ((nactenyByte = fis.read()) >= 0) {
                fos.write(nactenyByte);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Nebylo mozne otevrit nektery ze souboru");
        } catch (IOException ex) {
            System.out.println("Chyba pri provadeni kopie");
        } finally {
            if (fis != null) {
                fis.close();
            }
            if (fos != null) {
                fos.close();
            }
        }

    }

}
