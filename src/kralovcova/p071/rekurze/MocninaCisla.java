/*
 * This code is part of ALP subject
 */

package kralovcova.p071.rekurze;

/**
 *
 * @author Jirina
 */
public class MocninaCisla {
    
    /**
     * Celociselna mocnina realneho cisla
     * @param a zaklad 
     * @param n mocnitl
     * @return vysledek
     */
    public static double aNaN (double a, int n) {
        double v = 1;
        for (int i = 0; i < Math.abs(n); i++) {
            v *= a;
        }
        if (n < 0) return 1./v;
        return v;
    }
    
    /**
     * Celociselna mocnina realneho cisla rekurzivne
     * @param a zaklad 
     * @param n mocnitl
     * @return vysledek
     */
    public static double aNaNRek(double a, int n) {
        if (n == 0) return 1.;
        if (n < 0) return 1./aNaNRek(a, -n);
        return a * aNaNRek(a, n - 1);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(aNaN(2., 4));
        System.out.println(aNaNRek(2., 4));
        
        System.out.println(aNaN(10, -3));
        System.out.println(aNaNRek(10, -3));
    }

}
