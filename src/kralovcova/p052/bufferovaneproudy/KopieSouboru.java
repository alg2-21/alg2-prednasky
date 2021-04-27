/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *  
 */
package kralovcova.p052.bufferovaneproudy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
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
    private static final int BUF_LEN = 1024;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("vstupni soubor");
        String jmIn = sc.nextLine();
        System.out.println("vystupni soubor");
        String jmOut = sc.nextLine();

        // try-with-resources
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(jmIn));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(jmOut))) {

            //int nactenyByte;
            //while ((nactenyByte = bis.read()) >= 0) {
            //    bos.write(nactenyByte);
            //}
            
            
            //byte[] buf = new byte[BUF_LEN];
            //int pocet;
            //while ((pocet = bis.read(buf)) > 0) {
            //    bos.write(buf, 0, pocet);
            //}
            
        } catch (FileNotFoundException ex) {
            System.out.println("Chyba pri oteviranni nektereho ze souboru");
        } catch (IOException ex) {
            System.out.println("Chyba pri praci se soubory");
        } catch (Exception ex) {
            System.out.println("Jina chyba");
            System.out.println(ex.getMessage());
        }
    }

}
