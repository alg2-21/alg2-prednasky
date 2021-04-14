/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *
 */
package kralovcova.p031.vyjimky;

/**
 *
 * @author Jirina
 */
public class Obdelnik3 {
    private double a, b;

    private Obdelnik3(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public static Obdelnik3 getInstance(double a, double b) {
        if (a < 0) {
            return null;
        }
        if (b < 0) {
            return null;
        }
        return new Obdelnik3(a, b);
    }

    // ...
}
