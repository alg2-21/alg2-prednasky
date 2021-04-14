package kralovcova.p031.vyjimky;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Jirina
 */
public class ChybaMimoRozsah {

    public static Scanner sc = new Scanner(System.in);
    public static int KAPACITA = 5;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 0;
        double[] a = new double[KAPACITA];

        System.out.println("Zadavej cisla, ukonci nulou nebo zapornym cislem");

//        while ((a[n] = sc.nextDouble()) > 0) {
//            n++;
//        }
        try {
            double d = 1;
            do {
                try {
                    d = sc.nextDouble(); // 6+
                    if (d > 0) {
                        a[n] = d;
                        n++;
                    }
                } catch (InputMismatchException vyjimka) {
                    System.out.println("Chybne zadane realne cislo");
                    String str = sc.next();
                    System.out.println("zadano chybne " + str);
                }
            } while (d > 0);
            System.out.println("Cteni standardne dokonceno");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Nacitani ukonceno predcasne z duvodu vycerpani maxi poctu nacitanych cisel ");
            //System.out.println("Stala se chyba - chybny index do pole");
            //System.out.print("Vypis chybove zpravy: ");
            //System.out.println(e.getMessage());
            //System.out.println("Vypis zasobniku");
            //e.printStackTrace();
            //e.printStackTrace(System.out);
            //throw vyjimka;
        } finally {
            System.out.println("Uklizeni");
        }

        System.out.println(Arrays.toString(a));
        System.out.println("Konec programu");
    }
}
