package kralovcova.p031.vyjimky;

/**
 *
 * @author Jirina
 */
public class ChybaDeleniNulou {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // cela cisla
    // realna cisla
    float c, d;
    c = 7;
    System.out.println(c);

    
    // deleni cisla nulou
    c = c / -0.0f;
    System.out.println(c);
    
    
    
    // deleni nuly nulou
    d = 0;
    c = d / 0;
    System.out.println(c);
    
    
    System.out.println("konec programu");
  }
}
