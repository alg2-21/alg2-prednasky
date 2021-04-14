package kralovcova.p031.vyjimky;

/**
 *
 * @author Jirina
 */
public class ChybaNedostatekPameti {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    int[] a;
    int velikost = 2000000000; // (int)2E9
    
    //a = new int[velikost];
    
    boolean ok = false;
    
    
    while (!ok && (velikost > 1)) {
      try {
        System.out.format("Pokus o alokaci pameti o velikosti %d bytu%n", (long)velikost*4);
        a = new int[velikost];
        System.out.format("Alokovano pole pro %d celych cisel%n", velikost);
        ok = true;
      } catch (OutOfMemoryError err) {
        //System.out.println(err.getMessage());
        //System.out.println(err.getLocalizedMessage());
        //err.printStackTrace();
        System.out.format("Pole pro %d celych cisel se nepodarilo alokovat%n", velikost);
        velikost = velikost / 2;
      } finally {
        System.out.println(" ");
      }
    }
    
    
   System.out.println("Konec programu");
  }
}
