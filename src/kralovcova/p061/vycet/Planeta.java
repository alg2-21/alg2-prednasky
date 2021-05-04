/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *
 */

// ukazka pouziti vyctoveho typu
// prevzato z: Zakhour a kol. Java 6, vyukovy kurz

package kralovcova.p061.vycet;

/**
 *
 * @author Jirina
 */
public enum Planeta {
    
    MERKUR(3.303e+23, 2.4396e+6),
    VENUSE(4.896e+24, 6.0518e+6),
    ZEME(5.976e+24, 6.37814e+6),
    MARS(6.421e+23, 3.3972e+6),
    JUPITER(1.9e+27, 7.1492e+7),
    SATURN(5.688e+26, 6.0268e+7),
    URAN(8.686e+25, 2.5559e+7),
    NEPTUN(1.024e+26, 2.4746e+7),
    PLUTO(1.27e+22, 1.137e+6);

    private final double hmotnost;
    private final double polomer;
    // gravitacni konstanta
    private static final double G = 6.673E-11;

    private Planeta(double hmotnost, double polomer) {
        this.hmotnost = hmotnost;
        this.polomer = polomer;
    }

    public double getHmotnost() {
        return hmotnost;
    }

    public double getPolomer() {
        return polomer;
    }

    public double pritazlivostNaPovrchu() {
        return G * hmotnost / (polomer * polomer);
    }

    public double tihaNaPovrchu(double hmotnostTelesa) {
        return hmotnostTelesa * pritazlivostNaPovrchu();
    }

    public static void main(String[] args) {
        Planeta pl = Planeta.ZEME;
        System.out.println(pl.pritazlivostNaPovrchu());
        System.out.println(pl.tihaNaPovrchu(10));
    }
    
}
