/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *
 */
package kralovcova.p025.geomsdedicnost;

/**
 *
 * @author Jirina
 */
public class Obdelnik extends Geom{
    private final double a, b;

    public Obdelnik(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    @Override
    public double getPlocha() {
        return a * b;
    }

    @Override
    public double getObvod() {
        return 2 * (a + b);
    }

    
    
    
}
