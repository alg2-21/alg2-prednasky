package kralovcova.p031.vyjimky;

import java.util.Scanner;

/**
 *
 * @author Jirina
 */
public class ChybaVstupu {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    boolean ok = false;
    int n = 0;

    System.out.println("Zadej cele cislo:");
    n = sc.nextInt();

    /*
    System.out.println("Zadej cele cislo:");
    while (!ok) {
      try {
        n = sc.nextInt();
        ok = true;
      } catch ( e) {
        System.out.println("Chyba v zadavani, zkus to znova:");
        sc.nextLine();
      } finally {
        //neni nutne nemusi zde byt
      }
    }
     */

    System.out.println("Bylo zadano cislo " + n);
    System.out.println("Konec programu");
  }
}
