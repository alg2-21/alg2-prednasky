/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *
 */
package kralovcova.p01.geoms;

/**
 *
 * @author Jirina
 */
public final class Vektory {

    private Vektory() {
    }

    public static Vektor soucet(Vektor u, Vektor v) {
        return new Vektor(u.getX() + v.getX(), u.getY() + v.getY(), u.getZ() + v.getZ());
    }

    public static double skalarniSoucin(Vektor u, Vektor v) {
        return u.getX() * v.getX() + u.getY() * v.getY() + u.getZ() * v.getZ();
    }

//    public static Vektor vektorovySoucin(Vektor u, Vektor v) {
//
//    }
//
//    public static double uhel(Vektor u, Vektor v) {
//
//    }
}
