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
public class Ctverec extends Geom{
    private final double a;

    public Ctverec(double a) {
        this.a = a;
    }

    public double getA() {
        return a;
    }
    
    //..

    @Override
    public double getPlocha() {
        return a * a;
    }

    @Override
    public double getObvod() {
        return 4*a;
    }
}
