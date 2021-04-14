/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as free as you need to learn Java.
 *
 */
package kralovcova.p01.body;

/**
 * Trida Bod
 * Pro ziskani instance mimo tridu je k dispozici tovarni metoda
 * Konstruktor je v tomto případě privátní 
 * V dane implementaci se jedna o tridu konstantnich objektu
 * 
 * @author Jirina
 */
public class Bod3 {
    private final double x;
    private final double y;

    private Bod3(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public static Bod3 getInstance(double x, double y) {
        // overi podminky, zda je mozne z parametru vytvorit instanci
        // v teto tride nejsou specifikovane zadne dalsi pozminky pro vytvoření
        //  krome potreby zadani dvou realnych cisel - souradnic x, y
        return new Bod3(x, y);
    }
    
    public static Bod3 getInstance(Bod3 b) {
        // overi podminky, zda je mozne z parametru vytvorit instanci
        // v teto tride nejsou specifikovane zadne dalsi pozminky pro vytvoření
        //  krome potreby zadani dvou realnych cisel - souradnic x, y
        return new Bod3(b.x, b.y);
    }
    
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
