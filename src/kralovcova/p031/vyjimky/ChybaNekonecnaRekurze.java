package kralovcova.p031.vyjimky;

/**
 *
 * @author Jirina
 */
public class ChybaNekonecnaRekurze {
    static int pocet = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            delej();
            System.out.println("Uz je udelano");
        } catch (StackOverflowError e) {
            System.out.println("Dosla pamet v oblasti zasobniku programu");
        }
        System.out.println(pocet);
    }

    private static void delej() {
        double c = pocet;
        double d = c + 1;
        pocet++;
        delej();
    }

}
