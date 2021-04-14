/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *
 */
package kralovcova.p024.bodyskl;

/**
 *
 * @author Jirina
 */
public class Bod3d {

    private Bod2d bod2d;
    private double z;

    public Bod3d(double x, double y, double z) {
        bod2d = new Bod2d(x, y);
        this.z = z;
    }

    public double getX() {
        return bod2d.getX();
    }

    public double getY() {
        return bod2d.getY();
    }

    public double getZ() {
        return z;
    }

}
