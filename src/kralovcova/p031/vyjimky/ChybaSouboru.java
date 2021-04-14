package kralovcova.p031.vyjimky;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Jirina
 */
public class ChybaSouboru {

    private static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)   {

        FileReader r = null;
//        r = new FileReader("a.txt");

       // /*
    try {
      r = new FileReader("a.txt");
      r.read();
      System.out.println("OK");
      System.out.println("Stiskni enter");
      sc.nextLine();
    
    } catch (FileNotFoundException ex) {
      System.out.println("Nelze otevrit soubor, soubor pravdepodobne neexistuje ");
    } catch (IOException ex) {
        System.out.println("Chyba pri praci se s.");
    } finally {
      try {
        if (r != null)
        r.close();
      } catch (IOException ex) {
        System.out.println("Problemy se zaviranim souboru ");
       } catch (NullPointerException ex) {
        System.out.println("Soubor nebyl otevren ");
      }
    }
         // */
        System.out.println("Konec programu");
    }
}
