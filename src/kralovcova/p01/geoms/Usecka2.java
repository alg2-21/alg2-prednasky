/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *
 */
package kralovcova.p01.geoms;

import kralovcova.p01.body.Bod2;

/**
 *
 * @author Jirina
 */
public class Usecka2 {
    private final Bod2 b1;
    private final Bod2 b2;

    public Usecka2(Bod2 b1, Bod2 b2) {
        this.b1 = new Bod2(b1);
        this.b2 = new Bod2(b2);
    }
    
    public double getDelka() {
        return b1.getVzd(b2); // b2.getVzd(b1)
    }
    
}
