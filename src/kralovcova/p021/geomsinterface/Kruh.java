/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *
 */
package kralovcova.p021.geomsinterface;

/**
 *
 * @author Jirina
 */
public class Kruh implements Geom2D {
    private double r;

    public Kruh(double r) {
        this.r = r;
    }

    public double getR() {
        return r;
    }

    @Override
    public double getPlocha() {
        return Math.PI * r * r;
    }

    @Override
    public double getObvod() {
        return Math.PI * 2 * r;
    }
    
    
}
