/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *
 */
package kralovcova.p01.geoms;

import kralovcova.p01.body.Bod;

/**
 *
 * @author Jirina
 */
public class Usecka {
    private final Bod b1;
    private final Bod b2;

    public Usecka(Bod b1, Bod b2) {
        this.b1 = b1;
        this.b2 = b2;
    }
    
    public double getDelka() {
        return Math.hypot(b1.getX() - b2.getX(), b1.getY() - b2.getY());
    }
}
